package cleancode.studycafe.tobe;

import cleancode.studycafe.tobe.controller.StudyCafePassMachine;
import cleancode.studycafe.tobe.handler.InputHandler;
import cleancode.studycafe.tobe.handler.OutputHandler;
import cleancode.studycafe.tobe.handler.PassFileHandler;
import cleancode.studycafe.tobe.handler.PassHandler;
import cleancode.studycafe.tobe.handler.StudyCafeFileHandler;
import cleancode.studycafe.tobe.service.PassService;

public class StudyCafeApplication {

    public static void main(String[] args) {
        // 핸들러 세팅
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        StudyCafeFileHandler fileHandler = new StudyCafeFileHandler();

        // 핸들러 주입
        PassHandler passHandler = new PassFileHandler(fileHandler);
        PassService passService = new PassService(passHandler);

        StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(inputHandler, outputHandler, passService);
        studyCafePassMachine.run();
    }
}
