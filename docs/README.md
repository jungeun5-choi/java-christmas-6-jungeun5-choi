# 🎁 크리스마스 프로모션 🎅

- **식당에서 12월 이벤트 진행**
- ⭐ **중복 할인과 증정을 허용**

## 달력
![image](https://github.com/jungeun5-choi/java-christmas-6-jungeun5-choi/assets/119802267/bd37d8ec-7a22-4f31-b12d-1dcea30b0971)

## 메뉴

| 대분류 | 소분류 |  |  |
| :-: | :-: | --: | --- |
| **Menu** | **Appetizer** | name:  | 양송이수프, 타파스, 시저샐러드 |
|  |  | price:  | 6000, 5500, 8000 |
|  | **Main** | name:  | 티본스테이크, 바비큐립, 해산물파스타, 크리스마스파스타 |
|  |  | price: | 55000, 54000, 35000, 25000 |
|  | **Dessert** | name: | 초코케이크, 아이스크림 |
|  |  | price: | 15000, 5000 |
|  | **Drink** | name: | 제로콜라, 레드와인, 샴페인 |
|  |  | price: | 3000, 60000, 25000 |

<br>

## 🎄 12월 이벤트 계획

### 1. 크리스마스 디데이 할인

| 이벤트 명 | 기간 | 조건 | 혜택 | 비고 |
| --- | --- | --- | --- | --- |
| 크리스마스 디데이 할인 | `2023.12.1` ~ `2023.12.25` | 이벤트 기간 중 방문 (단, [주의 사항](#고객에게-안내할-이벤트-주의-사항)에 맞춰 주문) | 총 주문 금액에서 할인 금액만큼 할인 | 아래 참고 |
> #### 할인 금액:
> 12월 1일 = `1,000`원 할인<br>
> 12월 25일까지 할인 금액이 **복리로 증가 (`100`원 씩)** <br><br>
> e.g. 시작일인 12월 1일에 1,000원, 2일에 1,100원, ..., 25일엔 3,400원 할인<br>

### 2. 평일 할인

| 이벤트 명 | 기간 | 조건 | 혜택 | 비고 |
| --- | --- | --- | --- | --- |
| 평일 할인 | `2023.12.1` ~ `2023.12.31` | 일요일 ~ 목요일 방문하여, **디저트 메뉴** 주문 (단, [주의 사항](#고객에게-안내할-이벤트-주의-사항)에 맞춰 주문) | 디저트 1개당 1개당 2,023원 할인 | - |

### 3. 주말 할인

| 이벤트 명 | 기간 | 조건 | 혜택 | 비고 |
| --- | --- | --- | --- | --- |
| 주말 할인 | `2023.12.1` ~ `2023.12.31` | 금요일, 토요일 방문하여, **메인 메뉴** 주문 (단, [주의 사항](#고객에게-안내할-이벤트-주의-사항)에 맞춰 주문) | 메인 메뉴 1개당 2,023원 할인 | - |

### 4. 특별 할인

| 이벤트 명 | 기간 | 조건 | 혜택 | 비고 |
| --- | --- | --- | --- | --- |
| 특별 할인 | `2023.12.1` ~ `2023.12.31` | 이벤트 달력에 **🌟(별)이 있는 날** 방문 (단, [주의 사항](#고객에게-안내할-이벤트-주의-사항)에 맞춰 주문) | 총 주문 금액에서 1,000원 할인 | 🌟: 3, 10, 17, 24, 31일 |

### 5. 증정 이벤트

| 이벤트 명 | 기간 | 조건 | 혜택 | 비고 |
| --- | --- | --- | --- | --- |
| 증정 이벤트 | `2023.12.1` ~ `2023.12.31` | 총 주문 금액이 **12만원** 이상 주문 (단, [주의 사항](#고객에게-안내할-이벤트-주의-사항)에 맞춰 주문) | 샴페인 1개 증정 | 총 주문 금액은 할인이 적용되지 않은 총 주문 금액을 말함. |

<br>

## 혜택 금액에 따른 12월 이벤트 배지 부여

|  | 배지 종류 | 혜택 금액 기준 |
| :-: | :-: | --- |
| 1 | 별 | `5,000` ≤ `(총 혜택 금액)` < `10,000` |
| 2 | 트리 | `10,000` ≤ `(총 혜택 금액)` < `20,000` |
| 3 | 산타 | `20,000` ≤ `(총 혜택 금액)` |

> 참고: `(총 혜택 금액)` = `(할인 금액의 합계)` + `(증정 메뉴의 가격)`

 <br>

## 고객에게 안내할 이벤트 주의 사항
> 이벤트 공통 예외처리

|  | 주의사항 구분 | 주의사항 상세 |
| --- | --- | --- |
| 1 | 이벤트 적용 최소 주문 금액 조건 | 총 주문 금액 10,000원 이상 |
| 2 | 주문 불가 사항 | 음료만 주문 불가능 |
| 3 | 메뉴 주문 개수 제한 | 한 번에 최대 20개 주문 가능 |

> 참고: 시저샐러드-1, 티본스테이크-1, 크리스마스파스타-1, 제로콜라-3, 아이스크림-1의 총 개수는 7개

<br>

## '12월 이벤트 플래너' 개발 요청 사항
```
안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
```

> #### 📅 12월 이벤트 플래너 프로세스
> 
> 1⃣ 고객들이 [식당 방문 날짜]와 [메뉴]를 미리 선택 → 2⃣ 이벤트 플래너가 [주문 메뉴], [할인 전 총 주문 금액]과 [혜택 내역 미리 보기] 제공 <br><br>
> 
> *혜택 내역 미리 보기: [증정 메뉴], [혜택 내역], [총 혜택 금액], [할인 후 예상 결제 금액], [12월 이벤트 배지 내용] <br>

<br>

### 1. 고객들이 [식당 방문 날짜]와 [메뉴]를 미리 선택

#### 1-1. [식당 방문 날짜] 입력:

```
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
```

```
3
```

| 입력 구분 | [방문 날짜] | 입력 예 | 출력 예 |
| :-: | --- | --- | --- |
| **입력 형식** | `{1 이상, 31 이하의 숫자로만 입력}` | `3` | |
| **입력 예외 처리** | 입력 값이 1 이상 31 이하의 숫자가 아닌 경우 | | `[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.` |

#### 1-2. [메뉴] 입력:

```
주문하실 메뉴와 개수를 알려주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
```

```
티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1
```

| 입력 구분 | [메뉴] | 입력 예 | 출력 예 |
| :-: | --- | --- | --- |
| **입력 형식** | `메뉴-개수,메뉴-개수,…` | `티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1` | |
| **입력 예외 처리** | 1. 메뉴판에 없는 메뉴를 입력하는 경우 | | `[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.` |
|  | 2. 메뉴의 개수를 1 이상의 숫자로 입력하지 않는 경우 | | `[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.` |
|  | 3. 입력 형식이 예시와 다른 경우 | | `[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.` |
|  | 4. 중복 메뉴를 입력한 경우 (e.g. 시저샐러드-1,시저샐러드-1) | | `[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.` |
| **비고** | `,`로 입력 단위 구분 → `-`로 메뉴와 개수 구분 | | |

<br>

### 2. 이벤트 플래너가 [주문 메뉴], [할인 전 총 주문 금액]과 [혜택 내역 미리 보기] 제공

```
12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
```

#### 2-1. [주문 메뉴] 출력:

```
<주문 메뉴>
타파스 1개
제로콜라 1개
```

| 출력 구분 | [주문 메뉴] | 출력 예 |
| :-: | --- | --- |
| **출력 형식** | `메뉴 %s개\n메뉴 %s개...` | `타파스 1개\n제로콜라 1개` |
| **비고** | | 에피타이저 → 메인 → 디저트 → 음료 순으로 출력 | 

#### 2-2. [할인 전 총주문 금액] 출력:

```
<할인 전 총주문 금액>
8,500원
```

| 출력 구분 | [할인 전 총주문 금액] | 출력 예 |
| :-: | --- | --- |
| **출력 형식** | `%s원`  | `142,000원` |
| **비고** | | `1000` 단위마다 `,` 표기 |

#### 2-3. [증정 메뉴] 출력:

```
<증정 메뉴>
샴페인 1개
```

| 출력 구분 | [증정 메뉴] | 출력 예 |
| :-: | --- | --- |
| **출력 형식** | `샴페인 %s개` | `샴페인 1개` |
| **비고** | 증정 이벤트에 해당하지 않는 경우 | `없음` |

#### 2-4. [혜택 내역] 출력:

```
<혜택 내역>
크리스마스 디데이 할인: -1,200원
평일 할인: -4,046원
특별 할인: -1,000원
증정 이벤트: -25,000원
```

| 출력 구분 | [혜택 내역] | 출력 예 |
| :-: | --- | --- |
| **출력 형식** | `고객에게 적용된 이벤트 내역1\n고객에게 적용된 이벤트 내역2\n고객에게 적용된 이벤트 내역3\n...` | `크리스마스 디데이 할인: -1,200원\n평일 할인: -4,046원\n특별 할인: -1,000원\n증정 이벤트: -25,000원` |
| **비고** | 1. 적용된 이벤트가 없는 경우 | `없음` |
|  | 2. 혜택 내역에 여러 개의 이벤트가 적용된 경우 | [12월 이벤트 계획](#-12월-이벤트-계획) 작성 번호 순으로 출력 |

#### 2-5. [총혜택 금액] 출력:

```
<총혜택 금액>
-31,246원
```

| 출력 구분 | [총혜택 금액] | 출력 예 |
| :-: | --- | --- |
| **출력 형식** | `-%s원` | `-31,246원` |
| **비고** | `(총 혜택 금액)` = `(할인 금액의 합계)` + `(증정 메뉴의 가격)` |  |

#### 2-6. [할인 후 예상 결제 금액] 출력:

```
<할인 후 예상 결제 금액>
135,754원
```

| 출력 구분 | [할인 후 예상 결제 금액] | 출력 예 |
| :-: | --- | --- |
| **출력 형식** | `%s원` | `135,754원` |
| **비고** | `(할인 후 예상 결제 금액)` = `(할인 전 총주문 금액)` - `(할인 금액)` |  |

#### 2-7. [12월 이벤트 배지] 출력:

```
<12월 이벤트 배지>
산타
```

| 출력 구분 | [12월 이벤트 배지] | 출력 예 |
| :-: | --- | --- |
| **출력 형식** | `{뱃지 이름}` | `산타` |
| **비고** | 총 혜택 금액에 따라 배지 이름을 다르게 표기 | [혜택 금액에 따른 12월 이벤트 배지 부여](#혜택-금액에-따른-12월-이벤트-배지-부여) 참고 |
