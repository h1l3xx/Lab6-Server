class Users {
    private val oldUsers = mutableListOf<String>()
    var checker = true
    fun checkUser(userAddress : String): Boolean {
        if (oldUsers.isNotEmpty()){
            for (user in oldUsers){
                if (user == userAddress){
                    checker = false
                }
            }
        }
        return checker
    }
}