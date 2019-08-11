unit Unit_ganti_username;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls, Vcl.ExtCtrls, Data.DB,
  Data.Win.ADODB;

type
  TForm_ganti_username = class(TForm)
    Panel1: TPanel;
    Label1: TLabel;
    Label2: TLabel;
    Label3: TLabel;
    Edit_ID_petugas: TEdit;
    Edit_password_lama: TEdit;
    Edit_username: TEdit;
    Edit_username_baru: TEdit;
    Label4: TLabel;
    Label5: TLabel;
    Button_ganti_username: TButton;
    ADOQuery_ganti_username: TADOQuery;
    ADOQuery1: TADOQuery;
    Edit1: TEdit;
    Edit2: TEdit;
    procedure Button_ganti_usernameClick(Sender: TObject);
    procedure FormShow(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
    procedure cekusername;
    procedure gantiusername;
    procedure bersih;


  end;

var
  Form_ganti_username: TForm_ganti_username;

implementation

{$R *.dfm}

uses Unitdatamodul;

procedure TForm_ganti_username.bersih;
begin
Edit_ID_petugas.Clear;
Edit_password_lama.Clear;
Edit_username.Clear;
Edit_username_baru.Clear;
end;

procedure TForm_ganti_username.Button_ganti_usernameClick(Sender: TObject);
begin
cekusername;
end;

procedure TForm_ganti_username.cekusername;
begin
if (Edit_ID_petugas.Text='') or (Edit_password_lama.Text='') or (Edit_username.Text='') or (Edit_username_baru.Text='') then
    begin
      MessageDlg('Lengkapi Data',mtWarning,[mbOK],0);
      Abort;
    end
  else
with ADOQuery1 do
    begin
      Active:=False;
      SQL.Clear;
      SQL.Text:='Select * from tb_petugas where id_petugas='+QuotedStr(Edit_ID_petugas.Text);
      Active:=True;
    end;
  if  ADOQuery1.IsEmpty then
    begin
      MessageDlg('ID Anda Salah',mtWarning,[mbOK],0);
      Abort;
    end
   else if not ADOQuery1.IsEmpty then
    begin
      Edit1.Text:=ADOQuery1.FieldValues['pasword'];
      Edit2.Text:=ADOQuery1.FieldValues['username'];
      if (Edit1.Text=Edit_password_lama.Text) then
        begin
          gantiusername;
        end
      else if not (Edit1.Text=Edit_password_lama.Text) then
        begin
          MessageDlg('Password Lama Salah',mtError,[mbOK],0);
          Abort;
        end

end;
end;



procedure TForm_ganti_username.FormShow(Sender: TObject);
begin
bersih;
end;

procedure TForm_ganti_username.gantiusername;
begin
    if not (Edit2.Text=Edit_username.Text) then
    begin
      MessageDlg('Username Tidak Sama',mtWarning,[mbOK],0);
      Abort;
    end
  else
  with ADOQuery_ganti_username do
    begin
      Active:=False;
      SQL.Text:='Select * from tb_petugas';
      Active:=True;
    end;
  try Data_Module.ADOConnection1.BeginTrans;
  with ADOQuery_ganti_username do
    begin
      Active:=True;
      Close;
      SQL.Text:='Update tb_petugas set username='+QuotedStr(Edit_username_baru.Text)+' where id_petugas='+QuotedStr(Edit_ID_petugas.Text);
      ExecSQL;
    end;
  Data_Module.ADOConnection1.CommitTrans;
  MessageDlg('Username Berhasil di Ganti',mtInformation,[mbOK],0);
  except
  Data_Module.ADOConnection1.RollbackTrans;
  MessageDlg('Gagal Mengganti! Silahkan Periksa Koneksi Anda',mtWarning,[mbOK],0);
  end;
end;

end.
