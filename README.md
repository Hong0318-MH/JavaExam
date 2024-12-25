# JavaExam
강의실 좌석 예약 시스템
이 프로그램은 5x5 강의실 좌석에 대해 학생들이 예약을 할 수 있는 시스템입니다. GUI를 통해 학생의 학번과 이름을 입력하고, 빈 좌석을 선택하여 예약할 수 있습니다. 이미 예약된 좌석은 클릭할 수 없으며, 예약된 좌석에는 "예약됨"이라는 텍스트가 표시됩니다.

기능
좌석 예약: 학생이 좌석을 선택하면, 학번과 이름을 입력받고 해당 좌석을 예약합니다.
좌석 상태 표시: 예약된 좌석은 "예약됨" 텍스트로 표시되고, 빈 좌석은 "빈 자리"로 표시됩니다.
예약 불가능한 좌석: 이미 예약된 좌석은 클릭할 수 없으며, 클릭 시 예약된 자리라는 메시지가 표시됩니다.
입력 폼: 학생의 학번과 이름을 입력할 수 있는 텍스트 필드가 제공됩니다.
실행 방법
프로그램 실행:

코드가 포함된 파일을 컴파일합니다.
Main 클래스의 main 메서드를 실행하여 프로그램을 시작합니다.

코드 설명

1. Seat 클래스
Seat 클래스는 강의실 좌석을 나타내며, 학생의 학번(studentID)과 이름(name)을 저장합니다.

isReserved() 메서드는 해당 좌석이 예약되었는지 확인합니다.

reserve() 메서드는 학생의 학번과 이름을 받아 해당 좌석을 예약합니다.

toString() 메서드는 좌석의 상태를 문자열로 반환합니다. 

예약된 좌석에는 학번과 이름을, 빈 좌석에는 "빈 자리"라는 텍스트를 표시합니다.

2. Main 클래스
좌석 초기화: initializeSeats() 메서드는 5x5 크기의 좌석 배열을 초기화합니다.

GUI 구성: JFrame을 사용하여 기본 윈도우를 생성하고, BorderLayout으로 레이아웃을 설정합니다.

좌석 버튼은 JPanel에 GridLayout으로 배치되어 각 좌석을 선택할 수 있게 합니다.

입력 필드는 JTextField로 학생의 학번과 이름을 입력받습니다.

좌석 버튼 클릭 시 예약 여부를 확인하고, 예약할지 여부를 사용자에게 묻습니다.

버튼 업데이트: updateButtonLabel() 메서드는 좌석의 예약 상태를 버튼의 텍스트로 반영하고, 예약된 좌석은 클릭 불가능하게 만듭니다.

사용법

학번과 이름 입력:

화면 하단에 있는 텍스트 필드에 학번과 이름을 입력합니다.

좌석 예약:

빈 자리를 클릭하여 좌석을 선택합니다.

예약을 진행하려면 확인 메시지가 표시됩니다.

예약이 완료되면 해당 좌석은 "예약됨"으로 표시되고, 클릭할 수 없습니다.

예약 취소 기능: 현재는 예약만 가능하며, 예약 취소 기능을 추가할 수 있습니다.
좌석 정보 저장: 프로그램을 종료해도 예약 정보를 저장하여 다음에 실행할 때 다시 불러오는 기능을 추가할 수 있습니다.
다양한 좌석 배열: 좌석 크기나 배열을 변경할 수 있는 옵션을 제공할 수 있습니다