Feature: feature to test register functionality
  Scenario Outline: cek register with valid credentials
    Given browser terbuka
    And pengguna di halaman register
    When pengguna memasukkan <namapengguna> dan <sandi>
    And tombol register ditekan
    Then pengguna menuju ke halaman login
    Examples:
      |namapengguna|sandi|
      |123@gmail.com|123Patrick|
      |123@gmail.com|Patrick|