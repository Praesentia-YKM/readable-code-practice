package cleancode.studycafe.tobe.handler;

import cleancode.studycafe.tobe.model.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.StudyCafePass;
import cleancode.studycafe.tobe.model.StudyCafePassType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * csv파일 정보 읽어드리는 알고리즘 공통 로직 분리(파일 읽기와 파싱하기)
 */
public class StudyCafeFileHandler {

    public List<StudyCafePass> readStudyCafePasses() {
        return readFromFile("src/main/resources/cleancode/studycafe/pass-list.csv", this::parseStudyCafePass);
    }

    public List<StudyCafeLockerPass> readLockerPasses() {
        return readFromFile("src/main/resources/cleancode/studycafe/locker.csv", this::parseLockerPass);
    }

    // 각 pass타입 객체 리스트로 반환
    private <T> List<T> readFromFile(String filePath, Function<String[], T> parser) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            return lines.stream()
                .map(line -> line.split(","))
                .map(parser)
                .toList();
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }

    private StudyCafePass parseStudyCafePass(String[] values) {
        return StudyCafePass.of(
            StudyCafePassType.valueOf(values[0]),
            Integer.parseInt(values[1]),
            Integer.parseInt(values[2]),
            Double.parseDouble(values[3])
        );
    }

    private StudyCafeLockerPass parseLockerPass(String[] values) {
        return StudyCafeLockerPass.of(
            StudyCafePassType.valueOf(values[0]),
            Integer.parseInt(values[1]),
            Integer.parseInt(values[2])
        );
    }
}
