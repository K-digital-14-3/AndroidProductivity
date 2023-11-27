package com.example.androidscaffolding.ui.Auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidscaffolding.databinding.ActivityAuthBinding
import com.example.androidscaffolding.ui.Auth.fragment.OpeningDialogFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
//import kotlinx.androidx.synthetic.Auth.activity_auth.*



class AuthActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthBinding

    // 전역으로 사용할 FirebaseAuth 생성
    private var auth : FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)

        // 전역 변수 설정
        auth = Firebase.auth


        // to 회원가입 창
        binding.signupOKBtn.setOnClickListener {
            createAccount(binding.EmailEt.text.toString(), binding.PasswordEt.text.toString())
        }

        // 로그인 버튼
        binding.loginBtn.setOnClickListener {
            signIn(binding.EmailEt.text.toString(),binding.PasswordEt.text.toString())
        }


        // 회원가입해서 로그인하면 main으로 넘어가는 로직
        binding.loginBtn.setOnClickListener {
            createAccount(binding.EmailEt.text.toString(), binding.PasswordEt.text.toString())
        }




        /*
                /* 로그인 페이지에서 비밀번호 6자 미만으로 입력 시, 빨간색 상자 생성 */
                binding.PasswordEt.addTextChangedListener(object: TextWatcher {

                    override fun afterTextChanged(s: Editable?) {

                    }
                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                    }
                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                        // userinput 에 비밀번호 받기
                        var userinput = binding.PasswordEt.text.toString()


                        if ( userinput.length < 6 ) {

                            // 조건에 따른 색 변환
                            binding.statelayer.setBackgroundResource(R.drawable.textfield)

                            val bgShape = binding.statelayer.background as GradientDrawable
                            bgShape.setColor(resources.getColor(R.color.black))
                        }
                        else {
                            binding.statelayer.setBackgroundColor(resources.getColor(R.color.M3_sys_lighton_surface_variant))

                            val bgShape = binding.statelayer.background as GradientDrawable
                            bgShape.setColor(resources.getColor(R.color.black))
                        }


                /* 회원가입 페이지에서 형식(@)에 맞지 않는 이메일 입력 시, 빨간색 상자 생성 */

                        // userinput2 에 이메일 받기
                        var userinput2 = binding.EmailEt.text.toString()

                        if ( '@' in userinput2 ) {

                            // 조건에 따른 색 변환
                            binding.statelayer.setBackgroundResource(R.drawable.textfield)

                            val bgShape = binding.statelayer.background as GradientDrawable
                            bgShape.setColor(resources.getColor(R.color.black))
                        }
                        else {
                            binding.statelayer.setBackgroundColor(resources.getColor(R.color.M3_sys_lighton_surface_variant))

                            val bgShape = binding.statelayer.background as GradientDrawable
                            bgShape.setColor(resources.getColor(R.color.black))
                        }

                    }
                  }
                )


        */









/*
    // 기존 프래그먼트 : loginBtn 버튼 클릭 -> 메인 액티비티 실행
        loginBtn.setOnClickListener {
            var startMainActivityIntent = Intent(this@AuthActivity, MainActivity::class.java)
            startActivity(startMainActivityIntent)
            finish() // 액티비티 호출 후, 현재 액티비티 종료
        }
*/
        // 새 프래그먼트 : loginBtn 버튼 클릭 -> 메인 액티비티 실행
 //        override fun onCreate(savedInstanceState: Bundle?) {
 //           // 결과 전달 받음
            var result = getIntent().getIntExtra("key", 0)  		// int 타입을 받을 경우
            var nickname = getIntent().getStringExtra("key")		// string 타입을 받을 경우
 //       }



        // 인플레이트
        setContentView(binding.root)

        // 호스트
//               val navHostFragment = supportFragmentManager.findFragmentById(R.id.auth_nav_host) as NavHostFragment

        // 네비게이션 컨트롤러
//              val navController = navHostFragment.navController


              OpeningDialogFragment().show(supportFragmentManager, "GAME_DIALOG")
    }


    // 계정 생성: 회원가입 함수 createAccount -> onCreate 에 할당
    private fun createAccount(email: String, password: String) {

        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth?.createUserWithEmailAndPassword(email, password)
                ?.addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            this, "계정 생성 완료",
                            Toast.LENGTH_SHORT
                        ).show()
                        finish() // 가입창 종료
                    } else {
                        Toast.makeText(
                            this, "계정 생성 실패: ${task.exception?.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }

    // 로그인
    private fun signIn(email: String, password: String) {

        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth?.signInWithEmailAndPassword(email, password)
                ?.addOnCompleteListener(this) {
                        task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            baseContext, "로그인 성공",
                            Toast.LENGTH_SHORT
                        ).show()
                        moveMainPage(auth?.currentUser)

                    } else {
                        Toast.makeText(
                            baseContext, "로그인 실패",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }


    }



    // 로그아웃 X -> 자동 로그인
    // 회원가입 -> 바로 로그인
    override fun onStart() {
        super.onStart()
        moveMainPage(auth?.currentUser)
    }



    // 유저 정보 넘겨준 뒤, 메인 액티비티 호출
        fun moveMainPage(user: FirebaseUser?){


            if(user!= null){
                startActivity(Intent(this,AuthActivity::class.java))
                finish()


            }


    }


}

