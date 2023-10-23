Feature: Order Sauce Demo

  Scenario: Order Sauce Demo
    Given Login Sauce Demo
    When Isi Username
    And Isi Password
    Then Tombol Login Di Tekan
    And Berhasil masuk
    Then Klik Item Barang
    And Tekan Tombol Add To Cart
    Then Tombol Add To Cart Berubah Menjadi Remove

