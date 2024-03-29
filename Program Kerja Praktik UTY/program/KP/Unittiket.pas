unit Unittiket;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.Grids, Vcl.DBGrids, Vcl.StdCtrls,
  Vcl.ExtCtrls, Vcl.Buttons, Vcl.ComCtrls, Vcl.Menus;

type
  TForm_tiket = class(TForm)
    Panel1: TPanel;
    Label1: TLabel;
    Label2: TLabel;
    Label3: TLabel;
    Label4: TLabel;
    Label5: TLabel;
    Label6: TLabel;
    Label7: TLabel;
    Label8: TLabel;
    Label9: TLabel;
    Label10: TLabel;
    Label12: TLabel;
    Label13: TLabel;
    Label11: TLabel;
    Edit_pemesanan_tiket: TEdit;
    Edit_petugas_pemesanan_tiket: TEdit;
    Edit_nama_pemesan: TEdit;
    Edit_no_telepon_pemesan: TEdit;
    Edit_alamat_jemput: TEdit;
    Editalamat_tujuan: TEdit;
    Edit_jumlah_pembayaran: TEdit;
    Button_simpan_pemesanan_tiket: TButton;
    Button_reset_pemesanan_tiket: TButton;
    Edit_jalur: TEdit;
    Button_cari_jalur: TButton;
    Button_cari_jam: TButton;
    Edit_jam: TEdit;
    Edit_id_pemberangkatan: TEdit;
    Panel2: TPanel;
    DBGrid_pemesanan_tiket: TDBGrid;
    DateTimePicker_pemesanan: TDateTimePicker;
    Label14: TLabel;
    DateTimePicker_pemberangkatan: TDateTimePicker;
    Label15: TLabel;
    Edit_kota_awal: TEdit;
    Edit_kota_tujuan: TEdit;
    PopupMenu1: TPopupMenu;
    CETAK1: TMenuItem;
    procedure Button_cari_jalurClick(Sender: TObject);
    procedure Button_cari_jamClick(Sender: TObject);
    procedure FormShow(Sender: TObject);
    procedure Button_reset_pemesanan_tiketClick(Sender: TObject);
    procedure Button_simpan_pemesanan_tiketClick(Sender: TObject);
    procedure DBGrid_pemesanan_tiketDblClick(Sender: TObject);
    procedure SpeedButton1Click(Sender: TObject);
    procedure Edit_no_telepon_pemesanKeyPress(Sender: TObject; var Key: Char);
    procedure DateTimePicker_pemesananChange(Sender: TObject);
    procedure Button_pemesanan_tiketClick(Sender: TObject);
    procedure DBGrid_pemesanan_tiketCellClick(Column: TColumn);
    procedure CETAK1Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
    procedure nomer_urut_tiket;
    procedure SimpanDetilTrans;
    procedure SimpanTrans;
    procedure bersih;
    procedure tampil;
    procedure simpan;
    procedure muncul;
    procedure cetak;
    procedure nama_petugas;
//    procedure ubah;
//    procedure delete;
  end;

var
  Form_tiket: TForm_tiket;

implementation


uses
  Unitutama, Unitdatamodul, ADODB, Unit_cari_jalur, Unit_cari_jam,
  Unit_form_login_baru, strutils, Unit_cetak_tiket;

{$R *.dfm}
procedure TForm_tiket.muncul;
begin
 with Data_Module.ADOQuery_tampil do
 begin
   Edit_id_pemberangkatan.Text:=FieldValues['id_pemberangkatan'];
   Edit_alamat_jemput.Text:=FieldValues['alamat_jemput'];
   Edit_jumlah_pembayaran.Text:=FieldValues['total_harga'];
   Edit_pemesanan_tiket.Text:=FieldValues['kd_transtiket'];
 end;
end;


procedure TForm_tiket.nama_petugas;
begin
with Form_cetak_tiket.ADOQuery1 do
begin
  Active:=false;
  SQL.Text:= 'select nama from tb_petugas where id_petugas=' +QuotedStr(Edit_petugas_pemesanan_tiket.Text);
  Active:=True;
end;
 Form_cetak_tiket.QRnama_petugas.Caption:=Form_cetak_tiket.ADOQuery1.FieldByName('nama').AsString;
end;

procedure TForm_tiket.nomer_urut_tiket;
var
id,idjadi, nol:string;
begin
nol:='00';
with Data_Module.ADOQuery_trans_tiket do
begin
  SQL.Clear;
  sql.Add('select * from transaksi_tiket order by kd_transtiket');
  Open;
  if RecordCount > 0 then
  begin
    last;
    id:=FieldByName('kd_transtiket').AsString;
    idjadi:=RightStr(id,1);
    id:=IntToStr(StrToInt(idjadi)+1);
    idjadi:='TRT'+leftstr(nol,2-Length(id))+id;
    Edit_pemesanan_tiket.Text:=idjadi;
    end
    else
    begin
    Edit_pemesanan_tiket.text:='TRT01';
    end;
    end;
end;

procedure TForm_tiket.tampil;
begin
with Data_Module.ADOQuery_tampil do
begin
  active:=False;
  close;
  sql.Text:='select id_petugas,t.kd_transtiket,t.total_harga,t.tanggal_pemesanan,dt.nama_pemesan,dt.no_telphon,tj.kota_awal,tj.kota_tujuan,dt.alamat_jemput,dt.alamat_tujuan,dt.id_pemberangkatan, '+
 'dt.tanggal_pemberangkatan,tp.jam_berangkat '+
 'from transaksi_tiket t, detil_tiket dt,tb_pemberangkatan tp, tb_jalur tj '+
 'where t.kd_transtiket=dt.kd_transtiket and dt.id_pemberangkatan=tp.id_pemberangkatan and dt.id_jalur=tj.id_jalur '+
 'and t.tanggal_pemesanan= '+QuotedStr(DateToStr(DateTimePicker_pemesanan.Date));
  Active:=True;

end;
DBGrid_pemesanan_tiket.DataSource:=Data_Module.DataSource_tampil;
  Data_Module.DataSource_tampil.DataSet:=Data_Module.ADOQuery_tampil;
end;

procedure TForm_tiket.SimpanTrans;
begin
with Data_Module.ADOQuery_trans_tiket do
  begin
    Active:=false;
    SQL.Text:='select * from transaksi_tiket';
    Active:=true;
  end;
  try
  Data_Module.ADOConnection1.BeginTrans;
  with Data_Module.ADOQuery_trans_tiket do
  begin
    Active:=true;
     SQL.Text:='insert into transaksi_tiket values ('+QuotedStr(Edit_pemesanan_tiket.Text)+
     ','+QuotedStr(Edit_petugas_pemesanan_tiket.Text)+','+QuotedStr(Edit_jumlah_pembayaran.Text)+
     ','+QuotedStr(FormatDateTime('mm/dd/yyyy',DateTimePicker_pemesanan.Date))+')';
    ExecSQL;
    end;
Data_Module.ADOConnection1.CommitTrans;
Application.MessageBox('Data Telah Tersimpan ! ! !','INFORMASI',mb_ok+mb_iconinformation);
except
Data_Module.ADOConnection1.RollbackTrans;
Application.MessageBox('Data Gagal Tersimpan ! ! !','INFORMASI',mb_ok+MB_ICONERROR);
end;
tampil;
end;

procedure TForm_tiket.SpeedButton1Click(Sender: TObject);
begin
SimpanTrans;
end;

procedure TForm_tiket.SimpanDetilTrans;
begin
  with Data_Module.ADOQuery_trans_tiket do
  begin
    Active:=false;
    SQL.Text:='select * from detil_tiket';
    Active:=true;
  end;
  try
  Data_Module.ADOConnection1.BeginTrans;
  with Data_Module.ADOQuery_trans_tiket do
  begin
    Active:=true;
     SQL.Text:='insert into detil_tiket values ('+QuotedStr(Edit_pemesanan_tiket.Text)+
     ','+QuotedStr(Edit_nama_pemesan.Text)+','+QuotedStr(Edit_no_telepon_pemesan.Text)+
     ','+QuotedStr(Edit_jalur.Text)+','+QuotedStr(Edit_alamat_jemput.Text)+
     ','+QuotedStr(Editalamat_tujuan.Text)+','+QuotedStr(Edit_id_pemberangkatan.Text)+
     ','+QuotedStr(FormatDateTime('mm/dd/yyyy',DateTimePicker_pemberangkatan.Date))+')';
    ExecSQL;
    end;
Data_Module.ADOConnection1.CommitTrans;
Application.MessageBox('Data Telah Tersimpan ! ! !','INFORMASI',mb_ok+mb_iconinformation);
except
Data_Module.ADOConnection1.RollbackTrans;
Application.MessageBox('Data Gagal Tersimpan ! ! !','INFORMASI',mb_ok+MB_ICONERROR);
end;
end;

procedure TForm_tiket.bersih;
begin
 Edit_pemesanan_tiket.Clear;
//Edit_petugas_pemesanan_tiket.Clear;
Edit_petugas_pemesanan_tiket.Text:=Form_login_baru.Edit1.Text;
Edit_nama_pemesan.Clear;
Edit_no_telepon_pemesan.Clear;
Edit_alamat_jemput.Clear;
Editalamat_tujuan.Clear;
Edit_jumlah_pembayaran.Clear;
Edit_jalur.Clear;
Edit_jam.Clear;
Edit_id_pemberangkatan.Clear;
Edit_kota_awal.Clear;
Edit_kota_tujuan.Clear;
nomer_urut_tiket;
end;
procedure TForm_tiket.simpan;
begin
end;
procedure TForm_tiket.Button_cari_jalurClick(Sender: TObject);
begin
Form_cari_jalur.ShowModal;
end;

procedure TForm_tiket.Button_cari_jamClick(Sender: TObject);
begin
Form_cari_jam.ShowModal;
end;

procedure TForm_tiket.Button_pemesanan_tiketClick(Sender: TObject);
begin
cetak;
end;

procedure TForm_tiket.Button_reset_pemesanan_tiketClick(Sender: TObject);
begin
 bersih;
end;

procedure TForm_tiket.Button_simpan_pemesanan_tiketClick(Sender: TObject);
begin
if(Edit_pemesanan_tiket.Text = '') or (Edit_petugas_pemesanan_tiket.Text = '')
or (Edit_nama_pemesan.Text = '')or (Edit_no_telepon_pemesan.Text = '')
or (Edit_alamat_jemput.Text = '')or (Edit_jumlah_pembayaran.Text = '')
or (Edit_jalur.Text = '')or (Edit_jam.Text = '')
or (Edit_id_pemberangkatan.Text = '')or (Edit_kota_awal.Text = '')
or (Edit_kota_tujuan.Text = '') then
  begin
  ShowMessage('lengkapi data terlebih dahulu');
  Abort;
  end
  else
SimpanDetilTrans;
if MessageDlg('Ingin Transaksi Lagi?',mtConfirmation,[mbYes,mbNo],0)=mrYes then
  begin
  cetak;
    //Edit_nama_pemesan.Clear;
//Edit_no_telepon_pemesan.Clear;
Edit_alamat_jemput.Clear;
Editalamat_tujuan.Clear;
Edit_jumlah_pembayaran.Clear;
Edit_jalur.Clear;
Edit_jam.Clear;
Edit_id_pemberangkatan.Clear;
Edit_kota_awal.Clear;
Edit_kota_tujuan.Clear;
Edit_pemesanan_tiket.Enabled:=False;
Edit_petugas_pemesanan_tiket.Enabled:=False;
//bersih;
end
else
begin
  cetak;
  SimpanTrans;
  //bersih;
end;
end;

procedure TForm_tiket.cetak;
var tgl_brngkt:String;
begin
tgl_brngkt:=DateToStr(DateTimePicker_pemberangkatan.Date);
Form_cetak_tiket.QRLabel_ID_TIKET.Caption:=Edit_pemesanan_tiket.Text;
Form_cetak_tiket.QRLabel_NAMA.Caption:=Edit_nama_pemesan.Text;
Form_cetak_tiket.QRLabel_KOTA_TUJUAN.Caption:= Edit_kota_tujuan.Text;
Form_cetak_tiket.QRLabel_ALAMAT_TUJUAN.Caption:=Editalamat_tujuan.Text;
Form_cetak_tiket.QRLabel_TGL_BERANGKAT.Caption:=tgl_brngkt;
Form_cetak_tiket.QRLabel_HARGA.Caption:=Edit_jumlah_pembayaran.Text;
nama_petugas;
Form_cetak_tiket.QuickRep1.Preview;

end;

procedure TForm_tiket.CETAK1Click(Sender: TObject);
begin
nama_petugas;
Form_cetak_tiket.QuickRep1.Preview;
end;

procedure TForm_tiket.DateTimePicker_pemesananChange(Sender: TObject);
begin
tampil;
end;

procedure TForm_tiket.DBGrid_pemesanan_tiketCellClick(Column: TColumn);
begin
with Data_Module.ADOQuery_tampil do
begin
Form_cetak_tiket.QRLabel_ID_TIKET.Caption:=Data_Module.ADOQuery_tampil.Fields[1].AsString;
Form_cetak_tiket.QRLabel_NAMA.Caption:=Data_Module.ADOQuery_tampil.Fields[4].AsString;
Form_cetak_tiket.QRLabel_KOTA_TUJUAN.Caption:= Data_Module.ADOQuery_tampil.Fields[7].AsString;
Form_cetak_tiket.QRLabel_ALAMAT_TUJUAN.Caption:=Data_Module.ADOQuery_tampil.Fields[9].AsString;
Form_cetak_tiket.QRLabel_TGL_BERANGKAT.Caption:=Data_Module.ADOQuery_tampil.Fields[11].AsString;
Form_cetak_tiket.QRLabel_HARGA.Caption:=Data_Module.ADOQuery_tampil.Fields[2].AsString;
end;
end;

procedure TForm_tiket.DBGrid_pemesanan_tiketDblClick(Sender: TObject);
begin
muncul;
end;

procedure TForm_tiket.Edit_no_telepon_pemesanKeyPress(Sender: TObject;
  var Key: Char);
  //pagar 8 adalah back space
begin
if not (key in[#8, '0'..'9','+','-']) then begin
  ShowMessage('isikan angka pada nomer telephon');
  key :=#0;
end;

end;

procedure TForm_tiket.FormShow(Sender: TObject);
begin
bersih;
Edit_pemesanan_tiket.Enabled:=False;
Edit_petugas_pemesanan_tiket.Enabled:=False;
DateTimePicker_pemesanan.Date:=Now;
tampil;


end;

end.
