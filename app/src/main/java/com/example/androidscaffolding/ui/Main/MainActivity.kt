package com.example.androidscaffolding.ui.Main

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.androidscaffolding.R
import com.example.androidscaffolding.databinding.ActivityMainBinding


//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import com.example.androidscaffolding.R
//import androidx.navigation.fragment.NavHostFragment
//import androidx.navigation.ui.NavigationUI
//import com.example.androidscaffolding.databinding.ActivityMainBinding
//
class MainActivity : AppCompatActivity() {
   private lateinit var mainBinding: ActivityMainBinding

   override fun onCreate(savedInstanceState: Bundle?) {

       super.onCreate(savedInstanceState)

       mainBinding = ActivityMainBinding.inflate(layoutInflater)

       setContentView(mainBinding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(com.example.androidscaffolding.R.id.main_nav_host) as NavHostFragment
        // 네비게이션 컨트롤러
        val navController = navHostFragment.navController
//
//        // 바텀 네비게이션 뷰 와 네비게이션을 묶어준다
//        NavigationUI.setupWithNavController(mainBinding.mainBottomNav, navController)


   }
}










//
//class MainActivity : AppCompatActivity() {
//    private val Fragment_1 = 1
//    private val Fragment_2 = 2
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        findViewById<View>(R.id.btn1).setOnClickListener { FragmentView(Fragment_1) }
//        findViewById<View>(R.id.btn2).setOnClickListener { FragmentView(Fragment_2) }
//        FragmentView(Fragment_1)
//    }
//
//    private fun FragmentView(fragment: Int) {
//
//        //FragmentTransactiom를 이용해 프래그먼트를 사용합니다.
//        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
//        when (fragment) {
//            1 -> {
//                // 첫번 째 프래그먼트 호출
//                val fragment1 = Fragment1()
//                transaction.replace(R.id.fragment_container, fragment1)
//                transaction.commit()
//            }
//
//            2 -> {
//                // 두번 째 프래그먼트 호출
//                val fragment2 = Fragment2()
//                transaction.replace(R.id.fragment_container, fragment2)
//                transaction.commit()
//            }
//        }
//    }
//}



//@OptIn(ExperimentalMaterial3Api::class)
//
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            PersonalInfo2Theme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    var context = LocalContext.current
//                    val db = remember { AppDatabase.getDatabase(context) }
//                    val userList by db.userDao().getAll()
//                        .collectAsState(initial = emptyList())
//                    val scope = rememberCoroutineScope()
//                    var name by remember { mutableStateOf("") }
//                    var savedname by remember { mutableStateOf("") }
//                    var email by remember { mutableStateOf("") }
//                    var savedemail by remember { mutableStateOf("") }
//                    var phone by remember { mutableStateOf("") }
//                    var savedphone by remember { mutableStateOf("") }
//                    var age by remember { mutableStateOf("") }
//                    var savedage by remember { mutableStateOf("") }
//                    var uid by remember { mutableStateOf(0) }
//                    Box(modifier = Modifier.fillMaxSize()) {
//                        Column(
//                            modifier = Modifier.align(Alignment.Center),
//                            horizontalAlignment = Alignment.CenterHorizontally
//                        ) {
//                            TextField(
//                                value = name,
//                                onValueChange = { name = it },
//                                label = { Text(text = "enter your name") },
//                                placeholder = { Text(text = "") },
//                            )
//                            TextField(
//                                value = email,
//                                onValueChange = { email = it },
//                                label = { Text(text = "enter your email") },
//                                placeholder = { Text(text = "") }
//                            )
//                            TextField(
//                                value = phone,
//                                onValueChange = { phone = it },
//                                label = { Text(text = "enter your phone") },
//                                placeholder = { Text(text = "") }
//                            )
//                            TextField(value = age,
//                                onValueChange = { age = it },
//                                label = { Text(text = "enter your age") },
//                                placeholder = { Text(text = "") }
//                            )
//                            Button(onClick = {
//                                savedname = name
//                                savedemail = email
//                                savedphone = phone
//                                if (age.toIntOrNull() == null) {
//                                    age = "0"
//                                }
//                                savedage = age
//
//                                val newUser = User(
//                                    uid = uid,
//                                    name = name,
//                                    email = email,
//                                    phone = phone,
//                                    age = age.toInt()
//                                )
//                                scope.launch(Dispatchers.IO) {
//                                    db.userDao().insertAll(newUser)
//                                }
//                            }) {
//                                Text(text = "등록")
//                            }
//                            Spacer(
//                                modifier = Modifier
//                                    .width(20.dp)
//                            )
//                            Box(
//                                modifier = Modifier
//                                    .padding(20.dp)
//                            ) {
//                                val scrollState = rememberScrollState()
//                                Column {
//                                    Text(text = "이름 : $savedname")
//                                    Text(text = "이메일 : $savedemail")
//                                    Text(text = "전화번호 : $savedphone")
//                                    Text(text = "나이 : $savedage")
//                                    Button(onClick = {
//                                        val intent1 = Intent(context, MainActivity2::class.java)
//                                        intent1.putExtra("uid", uid)
//                                        intent1.putExtra("name", savedname)
//                                        intent1.putExtra("email", savedemail)
//                                        intent1.putExtra("phone", savedphone)
//                                        intent1.putExtra("age", savedage)
//                                        context.startActivity(intent1)
//                                    }) {
//                                        Text(text = "연락처 정보 보기")
//                                    }
//
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
//
//























