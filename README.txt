계산기 실행 방법
1. 첫 번째 수 입력
2. 사용할 연산기호 입력
   - 더하기 : +
   - 빼기 : -
   - 곱하기 : *
   - 나누기 : /
   - 제곱 : ^
   - 제곱근 : √
3. 단항식이 아닐 경우 연산할 두 번째 수 입력
4. 연산 결과 출력 및 데이터 저장 후 다음 행동 입력
   - 계산기 종료 : exit
   - 가장 먼저 저장된 데이터 삭제 후 재시작: remove
   - 저장된 데이터 출력 후 재시작: load
   - 다시 계산기 시작 : 그 외 문자열
5. load 입력 후 항목 선택
   - 1 : 첫 번째 데이터
   - 2 : 모든 데이터
   - 3 : 현재 출력 값 보다 큰 데이터


구현 방식
패키지를 구현 레벨에 따라 나눴습니다.
  - Lv 1 패키지 : 클래스를 사용하지 않는 계산기 구현
  - Lv 2 패키지 : 클래스를 사용한 계산기
  - Lv 3 패키지 : enum 클래스

Lv 2 패키지에서 예외처리를 진행하는 클래스들을 묶은 패키지, 연산을 진행하는 추상 클래스와 자식클래스를 묶은 패키지, 그 외 계산기를 작동시키는 클래스로 구분되어 있습니다.
  - exceptionClass 패키지 : 예외처리를 진행
  - operationClass 패키지 : 입력받은 데이터로 연산을 진행
  - Calculator 클래스 : 입력받은 데이터를 초기화 및 저장하고, 상황에 맞는 연산 클래스들을 호출함
  - CalculatorApp 클래스 : 계산기를 진행하는 인터페이스
  - Main 클래스 : 계산기를 작동시키는 클래스

Lv 2 패키지 내 클래스들에서 enmu클래스, 제네릭 및 람다&스트림을 사용하였습니다.
  - enum 클래스 : 사칙연산 데이터가 저장된 클래스. 입력받은 값을 저장된 사칙연산 데이터와 비교하여, true/false를 리턴하는 메서드를 포함하고 있고, CalculatorApp에서 사용
  - 제네릭 타입 : Calculator 클래스 및 연산 클래스들에 적용
  - 람다 & 스트림 : CalculatorApp 클래스에서 현재 출력 값 보다 큰 데이터를 출력하는 코드로 사용