Feature: Login Sauce Demo

  Scenario: Login Sauce Demo
    Given Halaman Login Sauce Demo
    When Input Username
    And Input Password
    And Menekan tombol Login
    Then Pengguna berhasil masuk
