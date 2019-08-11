unit Unitutama;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.Menus, Vcl.Imaging.jpeg,
  Vcl.ExtCtrls, Vcl.ComCtrls;

type
  TForm_utama = class(TForm)
    MainMenu1: TMainMenu;
    MASTER1: TMenuItem;
    PETUGAS1: TMenuItem;
    PEMBERANGKATAN1: TMenuItem;
    JALUR1: TMenuItem;
    TRANSAKSI: TMenuItem;
    IKET1: TMenuItem;
    BARANG1: TMenuItem;
    LAPORAN: TMenuItem;
    HELP2: TMenuItem;
    LOGIN1: TMenuItem;
    KONEKSI1: TMenuItem;
    KELUAR1: TMenuItem;
    HELP: TMenuItem;
    KONFIGURASI1: TMenuItem;
    N1: TMenuItem;
    logout1: TMenuItem;
    N2: TMenuItem;
    BERATBARANG1: TMenuItem;
    JENISBARANG1: TMenuItem;
    USERNAME1: TMenuItem;
    PASSWORD1: TMenuItem;
    RANSAKSITIKET1: TMenuItem;
    RANSAKSIPENGIRIMANMARANG1: TMenuItem;
    Image1: TImage;
    DateTimePicker1: TDateTimePicker;
    procedure PETUGAS1Click(Sender: TObject);
    procedure BARANG1Click(Sender: TObject);
    procedure IKET1Click(Sender: TObject);
    procedure JALUR1Click(Sender: TObject);
    procedure PEMBERANGKATAN1Click(Sender: TObject);
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
    procedure LOGIN1Click(Sender: TObject);
    procedure KONEKSI1Click(Sender: TObject);
    procedure KELUAR1Click(Sender: TObject);
    procedure logout1Click(Sender: TObject);
    procedure FormShow(Sender: TObject);
    procedure BERATBARANG1Click(Sender: TObject);
    procedure JENISBARANG1Click(Sender: TObject);
    procedure PASSWORD1Click(Sender: TObject);
    procedure USERNAME1Click(Sender: TObject);
    procedure RANSAKSITIKET1Click(Sender: TObject);
    procedure RANSAKSIPENGIRIMANMARANG1Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form_utama: TForm_utama;

implementation

uses
  Unitpetugas, Unitpemberangkatan, Unitjalur, Unittiket, Unittransaksibarang, Unit_form_login_baru,
  Unit_koneksi, Unit_berat_barang, Unit_jenis_barang, Unit_password_baru,
  Unit_ganti_username, Unit_laporan_tiket, Unit_laporan_barang, Unitdatamodul;

{$R *.dfm}

procedure TForm_utama.BARANG1Click(Sender: TObject);
begin
Form_pengiriman_barang.ShowModal;
end;

procedure TForm_utama.BERATBARANG1Click(Sender: TObject);
begin
Form_harga:=TForm_harga.Create(Application);
Form_harga.ShowModal;
end;

procedure TForm_utama.FormClose(Sender: TObject; var Action: TCloseAction);
begin
Application.Terminate;
end;

procedure TForm_utama.FormShow(Sender: TObject);
begin
Form_utama.logout1.Visible:=False;
Form_utama.LOGIN1.Visible:=True;
Form_utama.MASTER1.Visible:=False;
Form_utama.MASTER1.Enabled:=False;
Form_utama.LAPORAN.Visible:=False;
Form_utama.LAPORAN.Enabled:=False;
Form_utama.TRANSAKSI.Visible:=False;
Form_utama.TRANSAKSI.Enabled:=False;
DateTimePicker1.Date:=Now;


end;

procedure TForm_utama.IKET1Click(Sender: TObject);
begin
Form_tiket:=TForm_tiket.Create(Application);
Form_tiket.ShowModal;
end;

procedure TForm_utama.JALUR1Click(Sender: TObject);
begin
Form_jalur:=TForm_jalur.Create(Application);
Form_jalur.ShowModal;
end;

procedure TForm_utama.JENISBARANG1Click(Sender: TObject);
begin
Form_jenis_barang:=TForm_jenis_barang.Create(Application);
Form_jenis_barang.ShowModal;
end;

procedure TForm_utama.KELUAR1Click(Sender: TObject);
begin
Application.Terminate;
end;

procedure TForm_utama.KONEKSI1Click(Sender: TObject);
begin
Form_koneksi:=TForm_koneksi.Create(Application);
Form_koneksi.Show;
end;

procedure TForm_utama.LOGIN1Click(Sender: TObject);
begin
Form_login_baru:=TForm_login_baru.Create(Application);
Form_login_baru.Show;
end;

procedure TForm_utama.logout1Click(Sender: TObject);
begin
FormShow(Sender);
end;

procedure TForm_utama.PASSWORD1Click(Sender: TObject);
begin
Form_ganti_password.ShowModal;
end;

procedure TForm_utama.PEMBERANGKATAN1Click(Sender: TObject);
begin
Form_utama:=TForm_utama.Create(Application);
Form_pemberangkatan.ShowModal;
end;

procedure TForm_utama.PETUGAS1Click(Sender: TObject);
begin
Form_petugas:=TForm_petugas.Create(Application);
Form_petugas.ShowModal;
end;

procedure TForm_utama.RANSAKSIPENGIRIMANMARANG1Click(Sender: TObject);
begin
with Data_Module.ADOQuery_laporan_barang do
begin
  Connection:=Data_Module.ADOConnection1;
  Close;
  Active:=False;
  SQL.Clear;
  SQL.Text:='select tj.jenis_barang, db.nama_brg, db.nama_pengirim, db.nama_penerima, db.alamat_pengiriman, tb.tanggal_transaksi, tb.total_harga '+
' from tb_jenis_barang tj, detil_brg db, trans_brg tb '+
' where tb.kd_trans=db.kd_trans '+
' and db.id_jenis=tj.id_jenis '+
' and tb.tanggal_transaksi='+QuotedStr(FormatDateTime('yyyy/mm/dd',DateTimePicker1.Date));
Active:=True;
end;
with Form_laporan_barang do
begin
QuickRep1.DataSet:=Data_Module.ADOQuery_laporan_barang;
QRDBText_jenis.DataSet:=Data_Module.ADOQuery_laporan_barang;
QRDBText_jenis.DataField:='jenis_barang';
QRDBText_nama.DataSet:=Data_Module.ADOQuery_laporan_barang;
QRDBText_nama.DataField:='nama_brg';
QRDBText_pengirim.DataSet:=Data_Module.ADOQuery_laporan_barang;
QRDBText_pengirim.DataField:='nama_pengirim';
QRDBText_penerima.DataSet:=Data_Module.ADOQuery_laporan_barang;
QRDBText_penerima.DataField:='nama_penerima';
QRDBText_alamat_pengirim.DataSet:=Data_Module.ADOQuery_laporan_barang;
QRDBText_alamat_pengirim.DataField:='alamat_pengiriman';
QRDBText_tanggal.DataSet:=Data_Module.ADOQuery_laporan_barang;
QRDBText_tanggal.DataField:='tanggal_transaksi';
QRDBText_harga.DataSet:=Data_Module.ADOQuery_laporan_barang;
QRDBText_harga.DataField:='total_harga';
QuickRep1.Preview;
end;
end;

procedure TForm_utama.RANSAKSITIKET1Click(Sender: TObject);
begin
with Data_Module.ADOQuery_laporan_tiket do
begin
  Connection:=Data_Module.ADOConnection1;
  Close;
  Active:=False;
  SQL.Clear;
  sql.Text:='select tp.jam_berangkat, dt.nama_pemesan, tj.kota_awal, tj.kota_tujuan, tt.tanggal_pemesanan, tt.total_harga '+
' from tb_pemberangkatan tp, detil_tiket dt, tb_jalur tj, transaksi_tiket tt '+
' where tt.kd_transtiket=dt.kd_transtiket '+
' and dt.id_pemberangkatan=tp.id_pemberangkatan '+
' and dt.id_jalur=tj.id_jalur '+
' and tt.tanggal_pemesanan='+QuotedStr(FormatDateTime('yyyy/mm/dd',DateTimePicker1.Date));
 Active:=True;
 end;
 with Form_laporan_tiket do
 begin
   QuickRep1.DataSet:=Data_Module.ADOQuery_laporan_tiket;
   QRDBText_jam.DataSet:=Data_Module.ADOQuery_laporan_tiket;
   QRDBText_jam.DataField:='jam_berangkat';
   QRDBText_nama.DataSet:=Data_Module.ADOQuery_laporan_tiket;
   QRDBText_nama.DataField:='nama_pemesan';
   QRDBText_kota_awal.DataSet:=Data_Module.ADOQuery_laporan_tiket;
   QRDBText_kota_awal.DataField:='kota_awal';
   QRDBText_kota_tujuan.DataSet:=Data_Module.ADOQuery_laporan_tiket;
   QRDBText_kota_tujuan.DataField:='kota_tujuan';
   QRDBText_tanggal.DataSet:=Data_Module.ADOQuery_laporan_tiket;
   QRDBText_tanggal.DataField:='tanggal_pemesanan';
   QRDBText_harga.DataSet:=Data_Module.ADOQuery_laporan_tiket;
   QRDBText_harga.DataField:='total_harga';
   QuickRep1.Preview;
 end;
end;


procedure TForm_utama.USERNAME1Click(Sender: TObject);
begin
Form_ganti_username.ShowModal;
end;

end.
