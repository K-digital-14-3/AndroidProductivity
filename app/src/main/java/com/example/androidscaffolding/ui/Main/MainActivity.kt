package com.example.androidscaffolding.ui.Main

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.androidscaffolding.R
import com.example.androidscaffolding.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.navercorp.nid.NaverIdLoginSDK
import com.navercorp.nid.oauth.NidOAuthLogin
import com.navercorp.nid.oauth.OAuthLoginCallback
import com.navercorp.nid.profile.NidProfileCallback
import com.navercorp.nid.profile.data.NidProfileResponse


class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding:ActivityMainBinding

    private var auth : FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        auth = Firebase.auth

        /** Naver Login Module Initialize */
        val naverClientId = getString(R.string.social_login_info_naver_client_id)
        val naverClientSecret = getString(R.string.social_login_info_naver_client_secret)
        val naverClientName = getString(R.string.social_login_info_naver_client_name)
        NaverIdLoginSDK.initialize(this, naverClientId, naverClientSecret , naverClientName)

        setLayoutState(false)

        mainBinding.tvNaverLogin.setOnClickListener {
            startNaverLogin()
        }
        mainBinding.tvNaverLogout.setOnClickListener {
            startNaverLogout()
        }
        mainBinding.tvNaverDeleteToken.setOnClickListener {
            startNaverDeleteToken()
        }

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_nav_host) as NavHostFragment
        // 네비게이션 컨트롤러
        val navController = navHostFragment.navController

        // 바텀 네비게이션 뷰 와 네비게이션을 묶어준다
        NavigationUI.setupWithNavController(mainBinding.mainBottomNav, navController)

    }
    /**
     * 로그인
     * authenticate() 메서드를 이용한 로그인 */
    private fun startNaverLogin(){
        var naverToken :String? = ""

        val profileCallback = object : NidProfileCallback<NidProfileResponse> {
            override fun onSuccess(response: NidProfileResponse) {
                val userId = response.profile?.id
            //    mainBinding.tvResult.text = "id: ${userId} \ntoken: ${naverToken}"
                setLayoutState(true)
                Toast.makeText(this@MainActivity, "네이버 아이디 로그인 성공!", Toast.LENGTH_SHORT).show()
            }
            override fun onFailure(httpStatus: Int, message: String) {
                val errorCode = NaverIdLoginSDK.getLastErrorCode().code
                val errorDescription = NaverIdLoginSDK.getLastErrorDescription()
                Toast.makeText(this@MainActivity, "errorCode: ${errorCode}\n" +
                        "errorDescription: ${errorDescription}", Toast.LENGTH_SHORT).show()
            }
            override fun onError(errorCode: Int, message: String) {
                onFailure(errorCode, message)
            }
        }

        /** OAuthLoginCallback을 authenticate() 메서드 호출 시,
         * 파라미터로 전달하거나 NidOAuthLoginButton 객체에 등록하면 인증 종료 */
        val oauthLoginCallback = object : OAuthLoginCallback {
            override fun onSuccess() {
                // 네이버 로그인 인증 성공 시, 수행할 코드 추가
                naverToken = NaverIdLoginSDK.getAccessToken()
//                var naverRefreshToken = NaverIdLoginSDK.getRefreshToken()
//                var naverExpiresAt = NaverIdLoginSDK.getExpiresAt().toString()
//                var naverTokenType = NaverIdLoginSDK.getTokenType()
//                var naverState = NaverIdLoginSDK.getState().toString()

                // 로그인 유저 정보 가져오기
                NidOAuthLogin().callProfileApi(profileCallback)
            }
            override fun onFailure(httpStatus: Int, message: String) {
                val errorCode = NaverIdLoginSDK.getLastErrorCode().code
                val errorDescription = NaverIdLoginSDK.getLastErrorDescription()
                Toast.makeText(this@MainActivity, "errorCode: ${errorCode}\n" +
                        "errorDescription: ${errorDescription}", Toast.LENGTH_SHORT).show()
            }
            override fun onError(errorCode: Int, message: String) {
                onFailure(errorCode, message)
            }
        }

        NaverIdLoginSDK.authenticate(this, oauthLoginCallback)
    }

    /**
     * 로그아웃
     * 애플리케이션에서 로그아웃 - NaverIdLoginSDK.logout() 메서드 호출 */
    private fun startNaverLogout(){
        NaverIdLoginSDK.logout()
        setLayoutState(false)
        Toast.makeText(this@MainActivity, "네이버 아이디 로그아웃 성공!", Toast.LENGTH_SHORT).show()
    }

    /**
     * 연동 해제 => 클라이언트에 저장된 토큰, 서버에 저장된 토큰이 모두 삭제
     * 네이버 아이디, 애플리케이션의 연동 해제 => NidOAuthLogin().callDeleteTokenApi() 메서드로 구현
     */
    private fun startNaverDeleteToken(){
        NidOAuthLogin().callDeleteTokenApi(this, object : OAuthLoginCallback {
            override fun onSuccess() {
                //서버에서 토큰 삭제에 성공한 상태입니다.
                setLayoutState(false)
                Toast.makeText(this@MainActivity, "네이버 아이디 토큰삭제 성공!", Toast.LENGTH_SHORT).show()
            }
            override fun onFailure(httpStatus: Int, message: String) {
                // 서버에서 토큰 삭제에 실패했어도 클라이언트에 있는 토큰은 삭제되어 로그아웃된 상태입니다.
                // 클라이언트에 토큰 정보가 없기 때문에 추가로 처리할 수 있는 작업은 없습니다.
                Log.d("naver", "errorCode: ${NaverIdLoginSDK.getLastErrorCode().code}")
                Log.d("naver", "errorDesc: ${NaverIdLoginSDK.getLastErrorDescription()}")
            }
            override fun onError(errorCode: Int, message: String) {
                // 서버에서 토큰 삭제에 실패했어도 클라이언트에 있는 토큰은 삭제되어 로그아웃된 상태
                // 클라이언트에 토큰 정보가 없기 때문에 추가로 처리할 수 있는 작업은 X
                onFailure(errorCode, message)
            }
        })
    }

    private fun setLayoutState(login: Boolean){
        if(login){
            mainBinding.tvNaverLogin.visibility = View.GONE
            mainBinding.tvNaverLogout.visibility = View.VISIBLE
            mainBinding.tvNaverDeleteToken.visibility = View.VISIBLE
        }else{
            mainBinding.tvNaverLogin.visibility = View.VISIBLE
            mainBinding.tvNaverLogout.visibility = View.GONE
            mainBinding.tvNaverDeleteToken.visibility = View.GONE
        //    mainBinding.tvResult.text = ""
        }
    }
}
