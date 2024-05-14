# 쇼핑몰 프로젝트

spring

## API

### 상품

#### 상품 추가

| Method | URL       | HTTP Status Code |
|--------|-----------|------------------|
| GET    | /products | 201 / 400, 500   |

##### Request Body

{<br/>
"name": "상품 이름", <br/>
"desc": "상품 설명", <br/>
"price": 상품 가격, <br/>
"sellerId": 판매자 id, <br/>
"categoryId": 카테고리 id <br/>
}

##### Response Body

{<br/>
"id": 저장된 상품의 id <br/>
"name": "상품 이름", <br/>
"desc": "상품 설명", <br/>
"price": 상품 가격, <br/>
"sellerId": 판매자 id, <br/>
"categoryId": 카테고리 id <br/>
}

<br/>

#### 상품 수정

| Method | URL            | HTTP Status Code    |
|--------|----------------|---------------------|
| PUT    | /products/{id} | 200 / 400, 404, 500 |

##### Request Body

{<br/>
"name": "수정할 이름", <br/>
"desc": "수정할 설명", <br/>
"price": 수정할 가격, <br/>
"sellerId": 수정할 판매자 id, <br/>
"categoryId": 수정할 카테고리 id <br/>
}

##### Response Body

{<br/>
"id": 수정한 상품의 id <br/>
"name": "수정할 이름", <br/>
"desc": "수정할 설명", <br/>
"price": 수정할 가격, <br/>
"sellerId": 수정할 판매자 id, <br/>
"categoryId": 수정할 카테고리 id <br/>
}

<br/>

#### 전체 상품 조회

| Method | URL       | HTTP Status Code |
|--------|-----------|------------------|
| GET    | /products | 200 / 400, 500   |

##### Params

limit: 받을 컨텐츠 단위
currentPage: 현재 페이지

##### Response Body

[  { <br/>
"id": 0, <br/>
"name": "상품 이름", <br/>
"desc": "상품 설명", <br/>
"price": 상품 가격, <br/>
"sellerId": 판매자 id, <br/>
"categoryId": 카테고리 id <br/>
}, { }, { }, ... ]

<br/>

#### 카테고리별 상품 조회

| Method | URL       | HTTP Status Code |
|--------|-----------|------------------|
| GET    | /products | 200 / 400, 500   |

##### Params

limit: 받을 컨텐츠 단위
currentPage: 현재 페이지
categoryId: 카테고리 id

##### Response Body

[  { <br/>
"id": 0, <br/>
"name": "상품 이름", <br/>
"desc": "상품 설명", <br/>
"price": 상품 가격, <br/>
"sellerId": 판매자 id, <br/>
"categoryId": 카테고리 id <br/>
}, { }, { }, ... ]

<br/>

#### ID로 상품 조회

| Method | URL            | HTTP Status Code |
|--------|----------------|------------------|
| GET    | /products/{id} | 200 / 400, 404   |

##### Response Body

{ <br/>
"id": 0, <br/>
"name": "상품 이름", <br/>
"desc": "상품 설명", <br/>
"price": 상품 가격, <br/>
"sellerId": 판매자 id, <br/>
"categoryId": 카테고리 id <br/>
}

<br/>

#### 상품 삭제

| Method | URL              | HTTP Status Code |
|--------|------------------|------------------|
| POST   | /products/remove | 200 / 400, 500   |

##### Request Body

{<br/>
"productIds": [ 삭제할 상품 id1, ... ]<br/>
}

##### Response Body

[  { <br/>
"id": 0, <br/>
"name": "상품 이름", <br/>
"desc": "상품 설명", <br/>
"price": 상품 가격, <br/>
"sellerId": 판매자 id, <br/>
"categoryId": 카테고리 id <br/>
}, { }, { }, ... ]

<br/>

### 회원

#### 회원가입

| Method | URL          | HTTP Status Code |
|--------|--------------|------------------|
| POST   | /user/signup | 201 / 409, 500   |

##### Request Body

{<br/>
"email": "이메일", <br/>
"password": "비밀번호", <br/>
"nickname": "닉네임", <br/>
"contact": "연락처" <br/>
}

##### Response Body

{<br/>
"success": 성공여부(boolean) <br/>
"nickname": "닉네임" <br/>
}

<br/>

#### id 중복 검사

| Method | URL      | HTTP Status Code |
|--------|----------|------------------|
| POST   | /checkId | 200 / 409, 500   |

##### Request Body

{<br/>
"id": "가입하려는 id" <br/>
}

<br/>

#### 로그인

| Method | URL          | HTTP Status Code |
|--------|--------------|------------------|
| POST   | /user/signin | 201 / 400, 500   |

##### Request Body

{<br/>
"email": "이메일", <br/>
"password": "비밀번호" <br/>
}

##### Response Body

{<br/>
"id": "회원 id", <br/>
"email": "이메일", <br/>
"password": "비밀번호(jwt)", <br/>
"nickname": "닉네임", <br/>
"contact": "연락처" <br/>
}

<br/>

#### 회원 정보 수정

| Method | URL   | HTTP Status Code |
|--------|-------|------------------|
| PUT    | /user | 200 / 400, 500   |

##### Request Body

{<br/>
"id": "수정할 회원 id", <br/>
"email": "이메일", <br/>
"password": "비밀번호", <br/>
"nickname": "닉네임", <br/>
"contact": "연락처" <br/>
}

##### Response Body

{<br/>
"id": "회원 id", <br/>
"email": "이메일", <br/>
"password": "비밀번호(jwt)", <br/>
"nickname": "닉네임", <br/>
"contact": "연락처" <br/>
}

<br/>

#### 회원 정보 받기

| Method | URL   | HTTP Status Code |
|--------|-------|------------------|
| GET    | /user | 200 / 400, 500   |

##### Request Body

{<br/>
"id": "정보를 받을 회원의 id", <br/>
}

##### Response Body

{<br/>
"id": "회원 id", <br/>
"email": "이메일", <br/>
"password": "비밀번호(jwt)", <br/>
"nickname": "닉네임", <br/>
"contact": "연락처" <br/>
}
