Feature: Checkout Sauce Demo

  Scenario: Checkout Sauce Demo
    Given Login Halaman Web Sauce Demo
    When Isi Username Terdaftar
    And Isi Password Terdaftar
    Then Tekan Login
    And Berhasil Masuk Inventory
    Then Pilih Barang
    And Tekan Add To Cart
    Then Tombol Add To Cart Berubah
    And Tekan Tombol Keranjang
    And Tekan Tombol Checkout
    Then Isi Form Nama Depan
    And Isi Form Nama Belakang
    And Isi Kode Pos
    Then Tekan Continue
    And Tekan Finish
    Then Berhasil Checkout

