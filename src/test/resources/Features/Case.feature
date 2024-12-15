@Deneme
Feature: Ucus kalkis saatlerinin kontrolu

  Background:

  @Cases
  Scenario: 001 saat filtreleme fonksiyonun kontrolu
    * 2 saniye bekle
    * Bilet tipini gidis-donus sec
    * 1 saniye bekle
    * Kalkis yerine "İstanbul Sabiha Gökçen Havalimanı" yaz
    * 1 saniye bekle
   * Kalkis icin "İstanbul" tikla
    * 2 saniye bekle
    * Varis yerine "Ankara Esenboğa Havalimanı" yaz
    * 2 saniye bekle
    * Varis icin "Ankara" tikla
    * Gidis tarihini "2025-01-23" sec
    * Donus tarihini "2025-01-25" sec
    * Ucuz bilet bul butonuna bas
    * Liste sayfasinin geldigi gor
    * Gidis kalkis varis saatlerini ayarla
    * Listelenen ucuslarin gidis ve kalkis saatlerinin dogru geldigini kontrol et
    * 2 saniye bekle


  @Cases
  Scenario: 002 Havayolu listeleme kontrolu
    * 2 saniye bekle
    * Bilet tipini gidis-donus sec
    * 1 saniye bekle
    * Kalkis yerine "İstanbul Sabiha Gökçen Havalimanı" yaz
    * 2 saniye bekle
    * Kalkis icin "İstanbul" tikla
    * Varis yerine "Ankara Esenboğa Havalimanı" yaz
    * 2 saniye bekle
    * Varis icin "Ankara" tikla
    * Gidis tarihini "2025-01-21" sec
    * Donus tarihini "2025-01-25" sec
    * Ucuz bilet bul butonuna bas
    * Liste sayfasinin geldigi gor
    * Gidis kalkis varis saatlerini ayarla
    * "Pegasus" sec
    * 5 saniye bekle
    * Fiyatlarin arttigini ve "Pegasus" oldugunu kontrol et
    * 2 saniye bekle

  @Cases
  Scenario: 003 Impacti en yuksek bolge
    * 2 saniye bekle
    * Bilet tipini gidis-donus sec
    * 1 saniye bekle
    * Kalkis yerine "İstanbul Sabiha Gökçen Havalimanı" yaz
    * 2 saniye bekle
    * Kalkis icin "İstanbul" tikla
    * Varis yerine "Ankara Esenboğa Havalimanı" yaz
    * 2 saniye bekle
    * Varis icin "Ankara" tikla
    * Gidis tarihini "2025-01-21" sec
    * Donus tarihini "2025-01-25" sec
    * Kisi sayacini ac
    * 2 saniye bekle
    * Yetiskin sayisi 3 sec
    * Cocuk sayisi 2 sec
    * Bebek sayisi 1 sec
    * 2 saniye bekle
    * Tipi "Ekonomi" sec
    * 1 saniye bekle
    * Ucuz bilet bul butonuna bas
    * Liste sayfasinin geldigi gor
    * Gidis kalkis varis saatlerini ayarla
    * "Pegasus" sec
    * 5 saniye bekle
    * Fiyatlarin arttigini ve "Pegasus" oldugunu kontrol et
    * 2 saniye bekle
    * Ilk ucusu sec
    * 1 saniye bekle
    * Super Eco sec
    * Sec ve ilerle butonuna bas
    * 3 saniye bekle
    * Ilk donus ucagini sec
    * Donus icin Super Eco sec
    * Odemeye ilerle butonunu bekle


