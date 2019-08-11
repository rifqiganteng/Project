unit Unit_jenis_barang;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls, Vcl.Grids, Vcl.DBGrids,
  Vcl.ExtCtrls;

type
  TForm_jenis_barang = class(TForm)
    Panel1: TPanel;
    Label1: TLabel;
    Label3: TLabel;
    Label2: TLabel;
    Edit_id_jenis: TEdit;
    Edit_jenis_barang: TEdit;
    Edit_harga: TEdit;
    Panel2: TPanel;
    DBGrid_harga_jenis_barang: TDBGrid;
    Button_update: TButton;
    Button_delete: TButton;
    Button_simpan: TButton;
    procedure Button_simpanClick(Sender: TObject);
    procedure FormShow(Sender: TObject);
    procedure Button_deleteClick(Sender: TObject);
    procedure DBGrid_harga_jenis_barangCellClick(Column: TColumn);
    procedure Button_updateClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
    procedure tampil;
    procedure bersih;
    procedure nomer_urut_jenis;
  end;

var
  Form_jenis_barang: TForm_jenis_barang;

implementation

{$R *.dfm}

uses Unitdatamodul, strutils;

procedure TForm_jenis_barang.bersih;
begin
Edit_id_jenis.Clear;
Edit_jenis_barang.Clear;
Edit_harga.Clear;
end;

procedure TForm_jenis_barang.Button_deleteClick(Sender: TObject);
begin
try Data_Module.ADOConnection1.BeginTrans;
  with Data_Module.ADOQuery_jenis_barang do
    begin
      Close;
      Connection:=Data_Module.ADOConnection1;
      SQL.Text:='delete from tb_jenis_barang where id_jenis='+QuotedStr(Edit_id_jenis.Text);
      ExecSQL;
    end;
    Data_Module.ADOConnection1.CommitTrans;
    Application.MessageBox('Data Telah Dihapus ! ! !','INFORMASI',mb_ok+mb_iconinformation);
    bersih;
    nomer_urut_jenis;
    Button_simpan.Enabled:=True;
    Button_update.Enabled:=False;
    Button_delete.Enabled:=False;
    except
    Data_Module.ADOConnection1.RollbackTrans;
    Application.MessageBox('Data Gagal Dihapus ! ! !','INFORMASI',mb_ok+MB_ICONERROR);
    end;
    with Data_Module.ADOQuery_jenis_barang do
    begin
      Active:=false;
      SQl.Text:='select * from tb_jenis_barang';
      Active:=True;
      DBGrid_harga_jenis_barang.DataSource:=Data_Module.DataSource_jenis_barang;
      Data_Module.DataSource_jenis_barang.DataSet:=Data_Module.ADOQuery_jenis_barang;
      bersih;
      nomer_urut_jenis;
end;


end;


procedure TForm_jenis_barang.Button_simpanClick(Sender: TObject);
begin
if (Edit_id_jenis.Text='') or (Edit_jenis_barang.Text='') or (Edit_harga.Text='')then
begin
ShowMessage('Mohon isikan data dengan lengkap');
Edit_jenis_barang.SetFocus;
end
else
with Data_Module.ADOQuery_jenis_barang do
begin
try
  Data_Module.ADOConnection1.BeginTrans;
{
finally

end;  }
  Active:=false;
 Close;
 SQL.Clear;
 SQL.Text:='insert into tb_jenis_barang values('+QuotedStr(Edit_id_jenis.Text)+','+QuotedStr(Edit_jenis_barang.Text)+
 ','+QuotedStr(Edit_harga.Text)+')';
 ExecSQL;

  Data_Module.ADOConnection1.CommitTrans;
  Application.MessageBox('Data Berhasil Disimpan ! ! !','INFORMASI',mb_ok+mb_iconinformation);
  tampil;
  bersih;
  nomer_urut_jenis;
  except
Data_Module.ADOConnection1.RollbackTrans;
Application.MessageBox('Data Gagal Disimpan ! ! !','INFORMASI',mb_ok+MB_ICONERROR);
bersih;
nomer_urut_jenis;

end;
end;
end;

procedure TForm_jenis_barang.Button_updateClick(Sender: TObject);
begin
 if(Edit_id_jenis.Text = '')or (Edit_jenis_barang.Text = '')or(Edit_harga.Text = '') then
  begin
  ShowMessage('lengkapi data terlebih dahulu')
  end
  else
  begin

 with Data_Module.ADOQuery_jenis_barang do
  begin
  try
  Data_Module.ADOConnection1.BeginTrans;
    Active:=false;
    Close;
    SQl.Clear;
    SQl.Text:='update tb_jenis_barang set jenis_barang='+QuotedStr(Edit_jenis_barang.Text)+
    ',harga_jenis_barang='+QuotedStr(Edit_harga.Text)+
    ' where id_jenis='+QuotedStr(Edit_id_jenis.Text);
    ExecSQL;

  Data_Module.ADOConnection1.CommitTrans;
  Application.MessageBox('Data Berhasil Diubah ! ! !','INFORMASI',mb_ok+mb_iconinformation);
  tampil;
  bersih;
  nomer_urut_jenis;
 Button_simpan.Enabled:=True;
Button_update.Enabled:=False;
Button_delete.Enabled:=False;
  except
Data_Module.ADOConnection1.RollbackTrans;
Application.MessageBox('Data Gagal Diubah ! ! !','INFORMASI',mb_ok+MB_ICONERROR);
bersih;
nomer_urut_jenis;
end;
  end;
  end;
end;

procedure TForm_jenis_barang.DBGrid_harga_jenis_barangCellClick(
  Column: TColumn);
begin
Edit_id_jenis.Text:=Data_Module.ADOQuery_jenis_barang.Fields.Fields[0].AsString;
Edit_jenis_barang.Text:=Data_Module.ADOQuery_jenis_barang.Fields.Fields[1].AsString;
Edit_harga.Text:=Data_Module.ADOQuery_jenis_barang.Fields.Fields[2].AsString;
Button_simpan.Enabled:=False;
Button_update.Enabled:=True;
Button_delete.Enabled:=True;
end;

procedure TForm_jenis_barang.FormShow(Sender: TObject);
begin
tampil;
bersih;
nomer_urut_jenis;
Edit_id_jenis.Enabled:=False;
Button_simpan.Enabled:=True;
Button_update.Enabled:=False;
Button_delete.Enabled:=false;
end;

procedure TForm_jenis_barang.nomer_urut_jenis;
var
id,idjadi, nol:string;
begin
nol:='00';
with Data_Module.ADOQuery_jenis_barang do
begin
  SQL.Clear;
  sql.Add('select * from tb_jenis_barang order by id_jenis');
  Open;
  if RecordCount > 0 then
  begin
    last;
    id:=FieldByName('id_jenis').AsString;
    idjadi:=RightStr(id,1);
    id:=IntToStr(StrToInt(idjadi)+1);
    idjadi:='IDJEN'+leftstr(nol,2-Length(id))+id;
    Edit_id_jenis.Text:=idjadi;
    end
    else
    begin
    Edit_id_jenis.text:='IDJEN01';
    end;
end;



end;

procedure TForm_jenis_barang.tampil;
begin
with Data_Module.ADOQuery_jenis_barang do
begin
  Active:=False;
  SQL.Clear;
  SQL.Text:='select * from tb_jenis_barang';
  Active:=True;
  ExecSQL;

end;
end;

end.
