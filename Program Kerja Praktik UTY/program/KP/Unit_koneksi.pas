unit Unit_koneksi;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls;

type
  TForm_koneksi = class(TForm)
    Edit_SERVER: TEdit;
    Label1: TLabel;
    Label2: TLabel;
    Edit_DATABASE: TEdit;
    Button_KONEKSI: TButton;
    procedure Button_KONEKSIClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }

  end;

var
  Form_koneksi: TForm_koneksi;

implementation

{$R *.dfm}

uses Unitdatamodul;

procedure TForm_koneksi.Button_KONEKSIClick(Sender: TObject);
begin
try
with Data_Module.ADOConnection1 do
begin
  LoginPrompt:=False;
  ConnectionString:='Provider=SQLOLEDB.1;Integrated Security=SSPI;Persist Security Info=False;Initial Catalog='+Edit_DATABASE.Text+';Data Source='+Edit_SERVER.Text;
  Connected:=True;
  
end;
ShowMessage('koneksi berhasil');
Form_koneksi.Hide;
except
ShowMessage('koneksi gagal');






end;
end;

end.
