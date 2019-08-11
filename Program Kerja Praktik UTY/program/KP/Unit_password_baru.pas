unit Unit_password_baru;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls, Vcl.ExtCtrls, Data.DB,
  Data.Win.ADODB;

type
  TForm_ganti_password = class(TForm)
    Panel1: TPanel;
    Label1: TLabel;
    Label2: TLabel;
    Label3: TLabel;
    Label4: TLabel;
    Label5: TLabel;
    Edit_username_lama: TEdit;
    Edit_password_lama: TEdit;
    Edit_password_baru: TEdit;
    Edit_konfirmasi_pasword: TEdit;
    Button_ubah_password_baru: TButton;
    ADOQuery1: TADOQuery;
    Edit1: TEdit;
    ADOGanti: TADOQuery;
    procedure Button_ubah_password_baruClick(Sender: TObject);
    procedure FormShow(Sender: TObject);
  private
    { Private declarations }
    procedure CekUbahPass;
    procedure UbahPass;
    procedure bersih;
  public
    { Public declarations }
  end;

var
  Form_ganti_password: TForm_ganti_password;

implementation

{$R *.dfm}

uses Unitdatamodul;
procedure TForm_ganti_password.bersih;
begin
Edit_username_lama.Clear;
Edit_password_lama.Clear;
Edit_password_baru.Clear;
Edit_konfirmasi_pasword.Clear;
end;

procedure TForm_ganti_password.Button_ubah_password_baruClick(Sender: TObject);
begin
CekUbahPass;
end;

procedure TForm_ganti_password.CekUbahPass;
begin
if (Edit_username_lama.Text='') or (Edit_password_lama.Text='') or (Edit_password_baru.Text='') or (Edit_konfirmasi_pasword.Text='') then
    begin
      MessageDlg('Lengkapi Data',mtWarning,[mbOK],0);
      Abort;
    end
  else
with ADOQuery1 do
    begin
      Active:=False;
      SQL.Clear;
      SQL.Text:='select * from tb_petugas where username='+QuotedStr(Edit_username_lama.Text);
      Active:=True;
    end;
  if  ADOQuery1.IsEmpty then
    begin
      MessageDlg('Username Salah',mtWarning,[mbOK],0);
      Abort;
    end
   else if not ADOQuery1.IsEmpty then
    begin
      Edit1.Text:=ADOQuery1.FieldValues['pasword'];
      if (Edit1.Text=Edit_password_lama.Text) then
        begin
          UbahPass;
        end
      else if not (Edit1.Text=Edit_password_lama.Text) then
        begin
          MessageDlg('Password Lama Salah',mtError,[mbOK],0);
          Abort;
        end
    end;
end;

procedure TForm_ganti_password.FormShow(Sender: TObject);
begin
bersih;
end;

procedure TForm_ganti_password.UbahPass;
begin
if not (Edit_password_baru.Text=Edit_konfirmasi_pasword.Text) then
    begin
      MessageDlg('Password Tidak Sama',mtWarning,[mbOK],0);
      Abort;
    end
  else
  with ADOGanti do
    begin
      Active:=False;
      SQL.Text:='Select * from tb_petugas';
      Active:=True;
    end;
  try Data_Module.ADOConnection1.BeginTrans;
  with ADOGanti do
    begin
      Active:=True;
      Close;
      SQL.Text:='Update tb_petugas set pasword='+QuotedStr(Edit_password_baru.Text)+' where username='+QuotedStr(Edit_username_lama.Text);
      ExecSQL;
    end;
  Data_Module.ADOConnection1.CommitTrans;
  MessageDlg('Password Berhasil di Ganti',mtInformation,[mbOK],0);
  except
  Data_Module.ADOConnection1.RollbackTrans;
  MessageDlg('Gagal Mengganti! Silahkan Periksa Koneksi Anda',mtWarning,[mbOK],0);
  end;
end;

end.
