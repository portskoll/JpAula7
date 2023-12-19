package net.mundotela.exerciciosaula7

class MinhasImages(val img: Int) {

    fun getUrl(): String {
        return when (img) {
            1 -> "https://firebasestorage.googleapis.com/v0/b/app-texugo-imports.appspot.com/o/7urqHKGUILXqCXiE8ECCVlOcVk92%2Fupload%2Fimages%2Fprodutos%2F99901%2F99901_1.jpg?alt=media&token=bcad3654-3e29-48fb-8c73-0d7af3bbc570"
            2 -> "https://firebasestorage.googleapis.com/v0/b/app-texugo-imports.appspot.com/o/7urqHKGUILXqCXiE8ECCVlOcVk92%2Fupload%2Fimages%2Fprodutos%2F999011%2F999011_1.jpg?alt=media&token=edf42a0e-d47c-4168-a60b-630b954686f9"
            3 -> "https://firebasestorage.googleapis.com/v0/b/app-texugo-imports.appspot.com/o/uploads%2Fimages%2Fprodutos%2F1028%2F1028_1.jpg?alt=media&token=c096cc57-2b81-456f-a76c-be834fa77025"
            4 -> "https://firebasestorage.googleapis.com/v0/b/app-texugo-imports.appspot.com/o/7urqHKGUILXqCXiE8ECCVlOcVk92%2Fupload%2Fimages%2Fprodutos%2F1067%2F1067_1.jpg?alt=media&token=347c39af-4240-487c-b732-56fe287bc3d8"
            5 -> "https://firebasestorage.googleapis.com/v0/b/app-texugo-imports.appspot.com/o/uploads%2Fimages%2Fprodutos%2F1090%2F1090_1.jpg?alt=media&token=891d8eb9-4242-4e36-ae87-313fc260e34c"
            else -> ""
        }
    }
}
