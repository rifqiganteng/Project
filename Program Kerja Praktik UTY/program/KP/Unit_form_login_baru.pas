unit Unit_form_login_baru;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls, Vcl.ExtCtrls;

type
  TForm_login_baru = class(TForm)
    Panel1: TPanel;
    Edit_username_login: TEdit;
    Edit_pasword_login: TEdit;
    Button_login_baru: TButton;
    Button_cencel_baru: TButton;
    Edit1: TEdit;
    procedure Button_login_baruClick(Sender: TObject);
    procedure Button_cencel_baruClick(Sender: TObject);
    procedure Edit_username_loginClick(Sender: TObject);
    procedure FormShow(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form_login_baru: TForm_login_baru;

implementation

uses
  Unitdatamodul, Unitutama, Unittiket, Unit_koneksi, Unittransaksibarang,
  Unit_laporan_tiket, Unit_laporan_barang;

{$R *.dfm}
{
procedure TForm_login_baru.Edit_pasword_loginClick(Sender: TObject);
begin
Edit_pasword_login.Clear;
end;

procedure TForm_login_baru.Edit_username_loginClick(Sender: TObject);
begin
Edit_username_login.Clear;
end;

procedure TForm_login_baru.FormShow(Sender: TObject);
begin
Edit_username_login.Text:='USERNAME';
Edit_pasword_login.Text:='PASSWORD';
end;

procedure TForm_login_baru.Button_cencel_baruClick(Sender: TObject);
begin
Form_utama.ShowModal;
end;   }
procedure TForm_login_baru.Button_cencel_baruClick(Sender: TObject);
begin
Edit_username_login.Clear;
Edit_pasword_login.Clear;
end;

procedure TForm_login_baru.Button_login_baruClick(Sender: TObject);
begin
 with Data_Module.ADOQuery_login do
  begin
    Active:=False;
    Close;
    SQL.Text:='select * from tb_petugas where username='+QuotedStr(Edit_username_login.Text)+' and pasword='
    +QuotedStr(Edit_pasword_login.Text);
    Active:=True;
  end;
  if Data_Module.ADOQuery_login.IsEmpty then
  begin
    Application.MessageBox('Maaf !!! User Tidak Terdaftar Dalam Sistem','INFORMASI',32+MB_OK);
    Edit_username_login.SetFocus;
  end
  else
  begin
    if Data_Module.ADOQuery_login.FieldByName('hak_kses').AsString='ADMIN' then
    begin

    Form_utama.LAPORAN.Visible:=True;
    Form_utama.LAPORAN.Enabled:=True;
    Form_utama.MASTER1.Visible:=True;
    Form_utama.MASTER1.Enabled:=True;


       Application.MessageBox('Anda Berhasil Login Sebagai Admin','INFORMASI',32+MB_OK);
       Form_login_baru.Close;

Form_utama.logout1.Visible:=True;
Form_utama.LOGIN1.Visible:=False;
Form_login_baru.Edit1.Text:=Data_Module.ADOQuery_login.Fields.Fields[0].AsString;
Form_laporan_tiket.QRLabel_nama_admin_tiket.Caption:=Data_Module.ADOQuery_login.Fields[1].AsString;
Form_laporan_barang.QRLabel_nama_admin_barang.Caption:=Data_Module.ADOQuery_login.Fields[1].AsString;
Form_pengiriman_barang.Edit_petugas_pengiriman_barang.Text:= Form_login_baru.Edit1.Text;
    end
    else if Data_Module.ADOQuery_login.FieldByName('hak_kses').AsString='PETUGAS' then
    begin
       Application.MessageBox('Anda Berhasil Login Sebagai Petugas','INFORMASI', 32+MB_OK);
        Form_login_baru.Close;

Form_utama.logout1.Visible:=True;
Form_utama.LOGIN1.Visible:=False;

    Form_utama.TRANSAKSI.Visible:=True;
    Form_utama.TRANSAKSI.Enabled:=True;
    Form_login_baru.Edit1.Text:=Data_Module.ADOQuery_login.Fields.Fields[0].AsString;
    Form_pengiriman_barang.Edit_petugas_pengiriman_barang.Text:= Form_login_baru.Edit1.Text;
    end;
  end;
end;

procedure TForm_login_baru.Edit_username_loginClick(Sender: TObject);
begin
Edit_username_login.Text:='';
Edit_pasword_login.Text:='';
end;

procedure TForm_login_baru.FormShow(Sender: TObject);
begin
//Edit_username_login.Text:='username';
//Edit_pasword_login.Text:='password';
end;

end.
