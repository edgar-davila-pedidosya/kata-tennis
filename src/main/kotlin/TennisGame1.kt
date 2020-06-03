// Monolith coder: more methods equals more problems
class TennisGame1(private val player1Name: String, private val player2Name: String) : TennisGame {

    private var m_score1: Int = 0
    private var m_score2: Int = 0

    override fun wonPoint(playerName: String) {
        if (playerName === "player1")
            m_score1 += 1
        else
            m_score2 += 1
    }

    override fun getScore(): String {
        var score = ""
        var tempScore = 0
        if (m_score1 == m_score2) {
            score = Score.calculateTied(m_score1, m_score2).type
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            score = Score.calculateWinCondition(m_score1, m_score2).type
        } else {
            for (i in 1..2) {
                if (i == 1)
                    tempScore = m_score1
                else {
                    score += "-"
                    tempScore = m_score2
                }
                when (tempScore) {
                    0 -> score += "Love"
                    1 -> score += "Fifteen"
                    2 -> score += "Thirty"
                    3 -> score += "Forty"
                }
            }
        }
        return score
    }
}
