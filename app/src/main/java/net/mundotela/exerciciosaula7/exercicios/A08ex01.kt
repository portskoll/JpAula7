package net.mundotela.exerciciosaula7.exercicios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import net.mundotela.exerciciosaula7.R
import net.mundotela.exerciciosaula7.controller.UserResponse
import net.mundotela.exerciciosaula7.controller.UserResponseLista
import net.mundotela.exerciciosaula7.controller.service
import net.mundotela.exerciciosaula7.controller.serviceLista
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class A08ex01 : AppCompatActivity() {

    lateinit var dados: TextView
    lateinit var listaUsuarios: TextView
    lateinit var textuser: TextView
    lateinit var imguser: ImageView
    lateinit var btnBuscaUser: Button
    val listaUserGitHub = mutableListOf<UserResponseLista>()
    var contagem: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a08ex01)

        dados = findViewById(R.id.txt_user_git)
        listaUsuarios = findViewById(R.id.txt_lista)

        textuser = findViewById(R.id.txt_user_github)
        imguser = findViewById(R.id.img_user_github)
        btnBuscaUser = findViewById(R.id.btn_buscar_mg_github)


        //Exercicio 1
        try {
            service.getUser().enqueue(object : Callback<UserResponse> {
                override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                    val dadosRecebidos = response.body()
                    val usuario = dadosRecebidos?.login
                    val nome = dadosRecebidos?.name
                    dados.text = usuario + "\n" + nome
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    // Você pode lidar com falhas aqui
                    println("Falha ao obter o usuário: ${t.message}")
                }
            })
        } catch (e: Exception) {
            // Lidar com a exceção aqui
            println("Exceção capturada: ${e.message}")
        }


        //Exercicio 3
        try {
            serviceLista.getUserLista().enqueue(object : Callback<List<UserResponseLista>>{
                override fun onResponse(
                    call: Call<List<UserResponseLista>>,
                    response: Response<List<UserResponseLista>>
                ) {
                    val dadosLista = response.body()
                    val primeirosCincoItens = dadosLista?.take(20)

                    for (valores in primeirosCincoItens.orEmpty()){
                        listaUserGitHub.add(valores)
                    }

                    Log.d("Achei", listaUserGitHub.get(0).login)
                }

                override fun onFailure(call: Call<List<UserResponseLista>>, t: Throwable) {
                    listaUsuarios.text = "Deu Ruim"
                }
            })
        } catch (e: Exception) {
            Log.e("Erro", "Ocorreu um erro: ${e.message}")
        }




    }

    //Exercicio 2
    fun MostrarLista(view: View) {
        serviceLista.getUserLista().enqueue(object : Callback<List<UserResponseLista>>{
            override fun onResponse(
                call: Call<List<UserResponseLista>>,
                response: Response<List<UserResponseLista>>
            ) {
                val dadosLista = response.body()
                val primeirosCincoItens = dadosLista?.take(5)
                var lista = ""

                for (valores in primeirosCincoItens.orEmpty()){

                    lista += "ID : ${valores.id} Login: ${valores.login}\n"

                }

                listaUsuarios.text = lista

            }

            override fun onFailure(call: Call<List<UserResponseLista>>, t: Throwable) {
                listaUsuarios.text = "Deu Ruim"
            }
        })
    }

    fun buscaUserGitHub(view: View){

        textuser.text = "iD : ${listaUserGitHub.get(contagem).id} - ${listaUserGitHub.get(contagem).login}"
        try {
            Glide.with(this)
                .load(listaUserGitHub.get(contagem).avatar_url)
                .centerCrop()
                .placeholder(R.drawable.progressbaranimation)
                .error(R.drawable.try_later)
                .into(imguser)
        } catch (e: Exception) {
            Log.e("TAGImage", "Erro ao carregar imagem", e)
        }
        if (contagem > 18) contagem = -1
        contagem++




    }




}