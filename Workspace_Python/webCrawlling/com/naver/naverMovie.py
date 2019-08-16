# -*- coding:utf-8 -*-

# pip install BeautifulSoup4 (웹크롤링 라이브러리)
from bs4 import BeautifulSoup # 긁어온걸 파싱해주는 역할
import urllib.request # 긁어오는 역할.

# 응답된 데이터가 resp에 담겨있음.
resp = urllib.request.urlopen('https://movie.naver.com/movie/running/current.nhn')
# print(resp) 

# resp 파싱하기.
soup = BeautifulSoup(resp,'html.parser')
# print(soup)

# dl 태그에서 클래스명이 lst_dsc인 것 찾아오기
movieList = soup.findAll('dl', {'class','lst_dsc'})
# print(movieList)

# 이름과 별점 출력하기
for movieOne in movieList:
    link = movieOne.find('a') # 리스트 안에 a태그 검색
    num = movieOne.select('.num')[0] # 클래스명 검색.
    #print('%s %s' % (link.text, num.text))

# 이미지 소스 출력하기
movieImg = soup.findAll('div', {'class', 'thumb'})

for imgOne in movieImg:
    imgSrc = imgOne.find('img')
    print(imgSrc.get('src'))


'''    try:
        print(str(link.text).split(' ')[1])
    except IndexError:
        print(str(link.text).split(' ')[0]) '''