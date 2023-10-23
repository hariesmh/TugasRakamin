Feature: Failed Login Sauce Demo

  Scenario: Failed Login Sauce Demo
    Given Halaman Login
    When Masukkan Username
    And Masukkan Password Salah
    And Tekan Tombol Login
    Then Pengguna gagal masuk