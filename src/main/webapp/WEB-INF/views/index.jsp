<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <%@ include file="./include/static-head.jspf" %>
</head>

<body>

<div class="wrap">

    <!-- header -->
    <%@ include file="./include/header.jspf" %>
    <!-- //header -->

    <!-- section visual -->
    <section class="visual">
        <ul class="slide">
            <li>
                <img src="/img/visual1.jpg" alt="슬라이드 이미지1">
                <div class="txt">
                    <p>Creative design with Hong Studio</p>
                    <h3>Website & APP, <br>Responsive Web and <br>Brand Identity </h3>
                    <a href="#">See the work <span class="lnr lnr-chevron-right"></span></a>
                </div>
                <span class="scroll">Scroll down</span>
            </li>
            <li>
                <img src="/img/visual2.jpg" alt="슬라이드 이미지1">
                <div class="txt">
                    <p>Creative design with Hong Studio</p>
                    <h3>Website & APP, <br>Responsive Web and <br>Brand Identity </h3>
                    <a href="#">See the work <span class="lnr lnr-chevron-right"></span></a>
                </div>
                <span class="scroll">Scroll down</span>
            </li>
            <li>
                <img src="/img/visual3.jpg" alt="슬라이드 이미지1">
                <div class="txt">
                    <p>Creative design with Hong Studio</p>
                    <h3>Website & APP, <br>Responsive Web and <br>Brand Identity </h3>
                    <a href="#">See the work <span class="lnr lnr-chevron-right"></span></a>
                </div>
                <span class="scroll">Scroll down</span>
            </li>
            <li>
                <img src="/img/visual4.jpg" alt="슬라이드 이미지1">
                <div class="txt">
                    <p>Creative design with Hong Studio</p>
                    <h3>Website & APP, <br>Responsive Web and <br>Brand Identity </h3>
                    <a href="#">See the work <span class="lnr lnr-chevron-right"></span></a>
                </div>
                <span class="scroll">Scroll down</span>
            </li>
            <li>
                <img src="/img/visual5.jpg" alt="슬라이드 이미지1">
                <div class="txt">
                    <p>Creative design with Hong Studio</p>
                    <h3>Website & APP, <br>Responsive Web and <br>Brand Identity </h3>
                    <a href="#">See the work <span class="lnr lnr-chevron-right"></span></a>
                </div>
                <span class="scroll">Scroll down</span>
            </li>
            <li>
                <img src="/img/visual6.jpg" alt="슬라이드 이미지1">
                <div class="txt">
                    <p>Creative design with Hong Studio</p>
                    <h3>Website & APP, <br>Responsive Web and <br>Brand Identity </h3>
                    <a href="#">See the work <span class="lnr lnr-chevron-right"></span></a>
                </div>
                <span class="scroll">Scroll down</span>
            </li>
        </ul>
    </section>
    <!-- //section visual -->

    <!--  section contents   -->
    <section class="contents">
        <!-- section contents main-text -->
        <div class="main-text animate" data-animate="fadeInUp" data-duration="1s">
            <h3>Great experience <br> build great brands.</h3>
            <p>다양한 온라인 서비스들을 구축하고 운영해온 풍부한 경험으로<br class="mo">
                UI/UX 기획과 디자인 그리고 구축에서 운영까지, 우리 스튜디오는<br class="mo">
                고객의 비즈니스를 위해 수준 높은 결과물을 제작하는 크리에이티브<br class="mo">
                파트너(Creative Partner) 입니다.
                <span>Soongu Hong, HONG STUDIO</span>
            </p>
        </div>
        <!-- //section contents main-text -->

        <!-- section contents > .project -->
        <div class="project">
            <div class="top">
                <h3 class="animate" data-animate="fadeInLeft" data-duration="1s" data-delay="0.5s">Meet <br>Out Projects
                </h3>
                <a href="#">More Projects
                    <span class="lnr lnr-chevron-right"></span>
                </a>
            </div>
            <ul class="animate" data-animate="fadeInUp" data-duration="1s">
                <li>
                    <a href="#">
                        <img src="/img/project1.jpg" alt="project1">
                        <div class="name">
                            <span>Website</span>
                            <h3>Linkin Aviation</h3>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="/img/project2.jpg" alt="project2">
                        <div class="name">
                            <span>Website</span>
                            <h3>HEESUNG LMS</h3>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="/img/project3.png" alt="project3">
                        <div class="name">
                            <span>Website</span>
                            <h3>ORPHAN</h3>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="/img/project4.jpg" alt="project4">
                        <div class="name">
                            <span>Website</span>
                            <h3>APMA WEB/APP</h3>
                        </div>
                    </a>
                </li>
            </ul>
        </div>
        <!-- section contents > .project-->

        <!-- section contents > .partner -->
        <div class="partner">
            <h3>우리의 소중한 고객입니다.</h3>
            <ul class="animate" data-animate="fadeInRight" data-duration="1s">
                <li><img src="/img/partner1.png" alt=""></li>
                <li><img src="/img/partner2.png" alt=""></li>
                <li><img src="/img/partner3.png" alt=""></li>
                <li><img src="/img/partner4.png" alt=""></li>
                <li><img src="/img/partner5.png" alt=""></li>
                <li><img src="/img/partner6.png" alt=""></li>
                <li><img src="/img/partner7.png" alt=""></li>
                <li><img src="/img/partner8.png" alt=""></li>
            </ul>
        </div>

        <!-- section contents > .contact -->
        <div class="contact animate" data-animate="fadeIn" data-duration="2s" data-delay="0.5s">
            <div class="inner">
                <h3>당신의 프로젝트를 이야기해 주세요.</h3>
                <p class="tel">010.1234.1234</p>
                <p>모바일 앱/웹 디자인 및 웹 표준화 작업 <br> UI/UX설계 및 제안서 작성<br> 스프링 기반 웹사이트 구축 등을 제공합니다.</p>
            </div>
        </div>
    </section>
    <!--  //section contents   -->

    <!-- footer-->
    <%@ include file="./include/footer.jspf" %>
    <!-- //footer-->

</div>

</body>

</html>