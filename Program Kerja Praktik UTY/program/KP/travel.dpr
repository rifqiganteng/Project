program travel;

uses
  Vcl.Forms,
  Unit_cari_jalur in 'Unit_cari_jalur.pas' {Form_cari_jalur},
  Unit_cari_jam in 'Unit_cari_jam.pas' {Form_cari_jam},
  Unit_form_login_baru in 'Unit_form_login_baru.pas' {Form_login_baru},
  Unitdatamodul in 'Unitdatamodul.pas' {Data_Module: TDataModule},
  Unitjalur in 'Unitjalur.pas' {Form_jalur},
  Unitpemberangkatan in 'Unitpemberangkatan.pas' {Form_pemberangkatan},
  Unitpetugas in 'Unitpetugas.pas' {Form_petugas},
  Unittiket in 'Unittiket.pas' {Form_tiket},
  Unittransaksibarang in 'Unittransaksibarang.pas' {Form_pengiriman_barang},
  Unitutama in 'Unitutama.pas' {Form_utama},
  Vcl.Themes,
  Vcl.Styles,
  Unit_koneksi in 'Unit_koneksi.pas' {Form_koneksi},
  Unit_jenis_barang in 'Unit_jenis_barang.pas' {Form_jenis_barang},
  Unit_berat_barang in 'Unit_berat_barang.pas' {Form_harga},
  Unit_ganti_username in 'Unit_ganti_username.pas' {Form_ganti_username},
  Unit_password_baru in 'Unit_password_baru.pas' {Form_ganti_password},
  Unit_laporan_tiket in 'Unit_laporan_tiket.pas' {Form_laporan_tiket},
  Unit_laporan_barang in 'Unit_laporan_barang.pas' {Form_laporan_barang},
  Unit_cetak_tiket in 'Unit_cetak_tiket.pas' {Form_cetak_tiket},
  Unit_cetak_barang in 'Unit_cetak_barang.pas' {Form_cetak_barang};

{$R *.res}

begin
  Application.Initialize;
  Application.MainFormOnTaskbar := True;
  TStyleManager.TrySetStyle('TabletDark');
  Application.CreateForm(TForm_utama, Form_utama);
  Application.CreateForm(TForm_login_baru, Form_login_baru);
  Application.CreateForm(TForm_cari_jalur, Form_cari_jalur);
  Application.CreateForm(TForm_cari_jam, Form_cari_jam);
  Application.CreateForm(TData_Module, Data_Module);
  Application.CreateForm(TForm_jalur, Form_jalur);
  Application.CreateForm(TForm_pemberangkatan, Form_pemberangkatan);
  Application.CreateForm(TForm_petugas, Form_petugas);
  Application.CreateForm(TForm_tiket, Form_tiket);
  Application.CreateForm(TForm_pengiriman_barang, Form_pengiriman_barang);
  Application.CreateForm(TForm_koneksi, Form_koneksi);
  Application.CreateForm(TForm_jenis_barang, Form_jenis_barang);
  Application.CreateForm(TForm_harga, Form_harga);
  Application.CreateForm(TForm_ganti_username, Form_ganti_username);
  Application.CreateForm(TForm_ganti_password, Form_ganti_password);
  Application.CreateForm(TForm_laporan_tiket, Form_laporan_tiket);
  Application.CreateForm(TForm_laporan_barang, Form_laporan_barang);
  Application.CreateForm(TForm_cetak_tiket, Form_cetak_tiket);
  Application.CreateForm(TForm_cetak_barang, Form_cetak_barang);
  Application.Run;
end.
