package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.game.GameRunnable;

/**
 * ISP 위반
 *
 */
public class AnotherGame implements GameRunnable {

    @Override
    public void run() {
        // 게임 진행
    }

}
//public class AnotherGame implements Game {
//    @Override
//    public void initialize() {
//        // 이 게임은 initialize가 필요 없는데....?
//    }
//
//    @Override
//    public void run() {
//        // 게임 진행
//    }
//
//}
