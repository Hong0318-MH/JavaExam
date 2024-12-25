import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Seat {
    String studentID = null;
    String name = null;

    public boolean isReserved() {
        return studentID != null && name != null;
    }

    public void reserve(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    @Override
    public String toString() {
        if (isReserved()) {
            return studentID + " " + name;
        } else {
            return "빈 자리";
        }
    }
}

public class Main {
    static Seat[][] seats = new Seat[5][5]; // 5x5 강의실 좌석 배열
    static JButton[][] buttons = new JButton[5][5]; // 좌석에 대한 버튼
    static JTextField studentIDField = new JTextField(10);
    static JTextField nameField = new JTextField(10);

    public static void main(String[] args) {
        // 좌석 초기화
        initializeSeats();

        // 프레임 설정
        JFrame frame = new JFrame("강의실 예약 시스템");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new BorderLayout());

        // 좌석 버튼 패널
        JPanel seatPanel = new JPanel();
        seatPanel.setLayout(new GridLayout(5, 5));

        // 버튼을 좌석에 맞게 배치
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int seatNumber = i * 5 + j;
                buttons[i][j] = new JButton("" + (seatNumber + 1));
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 14));
                buttons[i][j].setPreferredSize(new Dimension(100, 100));
                final int row = i;
                final int col = j;

                // 버튼 클릭 시 예약 처리
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (seats[row][col].isReserved()) {
                            JOptionPane.showMessageDialog(frame, "이미 예약된 자리입니다.");
                        } else {
                            // 빈 자리에 예약
                            int option = JOptionPane.showConfirmDialog(frame,
                                    "예약하시겠습니까? (학번: " + studentIDField.getText() + ", 이름: " + nameField.getText() + ")");
                            if (option == JOptionPane.YES_OPTION) {
                                seats[row][col].reserve(studentIDField.getText(), nameField.getText());
                                updateButtonLabel();
                            }
                        }
                    }
                });

                seatPanel.add(buttons[i][j]);
            }
        }

        // 입력 패널
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("학번:"));
        inputPanel.add(studentIDField);
        inputPanel.add(new JLabel("이름:"));
        inputPanel.add(nameField);

        // 프레임에 컴포넌트 추가
        frame.add(seatPanel, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    // 좌석 초기화
    public static void initializeSeats() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                seats[i][j] = new Seat();
            }
        }
    }

    // 버튼에 표시된 좌석 상태 업데이트
    public static void updateButtonLabel() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (seats[i][j].isReserved()) {
                    buttons[i][j].setText("예약됨");
                    buttons[i][j].setEnabled(false); // 예약된 자리는 클릭 불가능
                } else {
                    buttons[i][j].setText("빈 자리");
                    buttons[i][j].setEnabled(true); // 빈 자리는 클릭 가능
                }
            }
        }
    }
}
