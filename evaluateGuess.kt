package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var absolutelyRight = 0
    var trueColor = 0
    var nextSecr = ""
    var nextGuess = ""
    for (i in 0 until CODE_LENGTH) if(secret[i] == guess[i]){
        absolutelyRight++
    }
    else{
        nextSecr += secret[i]
        nextGuess+=guess[i]
    }
    var trigger = false
    if(absolutelyRight!= CODE_LENGTH){
        for(i in 0 until (CODE_LENGTH-absolutelyRight)){
            trigger = false
            for(j in 0 until nextGuess.length){
                if(trigger == false) {
                    if(nextSecr[i] == nextGuess[j]) {
                        trigger = true
                        trueColor++
                        nextGuess = nextGuess.removeRange(j,j+1)
                    }
                }
            }
        }
    }
    else{
        return Evaluation(absolutelyRight,trueColor)
    }
    return Evaluation(absolutelyRight,trueColor)
}

