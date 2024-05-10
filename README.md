# 쇼핑몰 프로젝트

spring

## API

### 상품 추가
| Method | URL       | HTTP Status Code |
| ------ | --------- | ---------------- |
| GET    | /products | 201 / 400, 500   |
#### Request Body
{<br/>
"name": "상품 이름", <br/>
"desc": "상품 설명", <br/>
"price": 상품 가격, <br/>
"sellerId": 판매자 id, <br/>
"categoryId": 카테고리 id <br/>
}
#### Response Body
{<br/>
"id": 저장된 상품의 id <br/>
"name": "상품 이름", <br/>
"desc": "상품 설명", <br/>
"price": 상품 가격, <br/>
"sellerId": 판매자 id, <br/>
"categoryId": 카테고리 id <br/>
}

### 상품 수정
| Method | URL            | HTTP Status Code    |
|--------|----------------|---------------------|
| PUT    | /products/{id} | 200 / 400, 404, 500 |
#### Request Body
{<br/>
"name": "수정할 이름", <br/>
"desc": "수정할 설명", <br/>
"price": 수정할 가격, <br/>
"sellerId": 수정할 판매자 id, <br/>
"categoryId": 수정할 카테고리 id <br/>
}
#### Response Body
{<br/>
"id": 수정한 상품의 id <br/>
"name": "수정할 이름", <br/>
"desc": "수정할 설명", <br/>
"price": 수정할 가격, <br/>
"sellerId": 수정할 판매자 id, <br/>
"categoryId": 수정할 카테고리 id <br/>
}

### 상품 조회
| Method | URL                   | HTTP Status Code  |
|--------|-----------------------|-------------------|
| GET    | /products/ | 200 / 400, 500 |
#### Params
limit: 받을 컨텐츠 단위
currentPage: 현재 페이지
#### Response Body
[  { <br/>
"id": 0, <br/>
"name": "상품 이름", <br/>
"desc": "상품 설명", <br/>
"price": 상품 가격, <br/>
"sellerId": 판매자 id, <br/>
"categoryId": 카테고리 id <br/>
}, {  }, {  }, ... ]

### 카테고리별 상품 조회
| Method | URL                   | HTTP Status Code  |
|--------|-----------------------|-------------------|
| GET    | /products/ | 200 / 400, 500 |
#### Params
limit: 받을 컨텐츠 단위
currentPage: 현재 페이지
categoryId: 카테고리 id
#### Response Body
[  { <br/>
"id": 0, <br/>
"name": "상품 이름", <br/>
"desc": "상품 설명", <br/>
"price": 상품 가격, <br/>
"sellerId": 판매자 id, <br/>
"categoryId": 카테고리 id <br/>
}, {  }, {  }, ... ]