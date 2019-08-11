unit Unit_berat_barang;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls, Vcl.Grids, Vcl.DBGrids,
  Vcl.ExtCtrls;

type
  TForm_harga = class(TForm)
    Panel: TPanel;
    Label1: TLabel;
    Label2: TLabel;
    Label3: TLabel;
    Edit_id_berat: TEdit;
    Edit_berat_kg: TEdit;
    Edit_harga_berat: TEdit;
    Panel1: TPanel;
    DBGrid_berat: TDBGrid;
    Button_update: TButton;
    Button_delete: TButton;
    Button_simpan: TButton;
    procedure Button_updateClick(Sender: TObject);
    procedure Button_simpanClick(Sender: TObject);
    procedure FormShow(Sender: TObject);
    procedure Button_deleteClick(Sender: TObject);
    procedure DBGrid_beratCellClick(Column: TColumn);
  private
    { Private declarations }
  public
    { Public declarations }
    procedure nomer_urut_berat;
    procedure tampil;
    procedure bersih;
  end;

var
  Form_harga: TForm_harga;

implementation

{$R *.dfm}

uses Unitdatamodul, strutils;

procedure  TForm_harga.tampil;
begin
with Data_Module.ADOQuery_berat_barang do
begin
Active:=False;
Close;
sql.Clear;
sql.Text:= 'select * from tb_berat';
Active:=True;


end;
end;

procedure TForm_harga.bersih;
begin
Edit_id_berat.Clear;
Edit_berat_kg.Clear;
Edit_harga_berat.Clear;
end;

procedure TForm_harga.Button_deleteClick(Sender: TObject);
begin
try Data_Module.ADOConnection1.BeginTrans;
  with Data_Module.ADOQuery_berat_barang do
    begin
     Active:=False;
      Close;
     SQL.Clear;
      SQL.Text:='delete from tb_berat where id_berat='+QuotedStr(Edit_id_berat.Text);
      ExecSQL;
    end;
    Data_Module.ADOConnection1.CommitTrans;
    Application.MessageBox('Data Telah Dihapus ! ! !','INFORMASI',mb_ok+mb_iconinformation);
    nomer_urut_berat;
    bersih;
    Button_simpan.Enabled:=True;
    Button_delete.Enabled:=False;
    Button_update.Enabled:=False;

    except
    Data_Module.ADOConnection1.RollbackTrans;
    Application.MessageBox('Data Gagal Dihapus ! ! !','INFORMASI',mb_ok+MB_ICONERROR);
    end;
    with Data_Module.ADOQuery_berat_barang do
    begin
      Active:=false;
      SQl.Text:='select * from tb_berat';
      Active:=True;
      DBGrid_berat.DataSource:=Data_Module.DataSource_berat_barang;
      Data_Module.DataSource_berat_barang.DataSet:=Data_Module.ADOQuery_berat_barang;
      bersih;
      nomer_urut_berat;
end;

end;

procedure TForm_harga.Button_simpanClick(Sender: TObject);
begin
if (Edit_id_berat.Text='') or (Edit_berat_kg.Text='') or (Edit_harga_berat.Text='')then
begin
ShowMessage('Mohon isikan data dengan lengkap');
Edit_berat_kg.SetFocus;
end
else
with Data_Module.ADOQuery_berat_barang do
begin
try
  Data_Module.ADOConnection1.BeginTrans;
{
finally

end;  }
  Active:=false;
 Close;
 SQL.Clear;
 SQL.Text:='insert into tb_berat values('+QuotedStr(Edit_id_berat.Text)+','+QuotedStr(Edit_berat_kg.Text)+
 ','+QuotedStr(Edit_harga_berat.Text)+')';
 ExecSQL;

  Data_Module.ADOConnection1.CommitTrans;
  Application.MessageBox('Data Berhasil Disimpan ! ! !','INFORMASI',mb_ok+mb_iconinformation);
  tampil;
  except
Data_Module.ADOConnection1.RollbackTrans;
Application.MessageBox('Data Gagal Disimpan ! ! !','INFORMASI',mb_ok+MB_ICONERROR);

 end;
 begin
  with Data_Module.ADOQuery_berat_barang do
 begin
   Active:=false;
   SQL.Text:='select*from tb_berat';
   Active:=true;
   ExecSQL;
   bersih;
   nomer_urut_berat;


end;
end;
end;
end;

procedure TForm_harga.Button_updateClick(Sender: TObject);
begin
 if(Edit_id_berat.Text = '') or (Edit_berat_kg.Text = '') or (Edit_harga_berat.Text = '') then
  begin
  ShowMessage('lengkapi data terlebih dahulu')
  end
  else
  begin
 with Data_Module.ADOQuery_berat_barang do
  begin
  try
  Data_Module.ADOConnection1.BeginTrans;
    Active:=false;
    Close;
    SQl.Clear;
    SQl.Text:='update tb_berat set berat_per_kg='+QuotedStr(Edit_berat_kg.Text)+
    ',harga_per_kg='+QuotedStr(Edit_harga_berat.Text)+
    ' where id_berat='+QuotedStr(Edit_id_berat.Text);
    ExecSQL;

  Data_Module.ADOConnection1.CommitTrans;
  Application.MessageBox('Data Berhasil Diubah ! ! !','INFORMASI',mb_ok+mb_iconinformation);
  tampil;
  bersih;
nomer_urut_berat;
Button_simpan.Enabled:=True;
Button_update.Enabled:=False;
Button_delete.Enabled:=False;
  except
Data_Module.ADOConnection1.RollbackTrans;
Application.MessageBox('Data Gagal Diubah ! ! !','INFORMASI',mb_ok+MB_ICONERROR);
bersih;
nomer_urut_berat;


end;

  end;
end;

end;

procedure TForm_harga.DBGrid_beratCellClick(Column: TColumn);
begin
Edit_id_berat.Text:=Data_Module.ADOQuery_berat_barang.Fields.Fields[0].AsString;
Edit_berat_kg.Text:=Data_Module.ADOQuery_berat_barang.Fields.Fields[1].AsString;
Edit_harga_berat.Text:=Data_Module.ADOQuery_berat_barang.Fields.Fields[2].AsString;
Button_simpan.Enabled:=False;
Button_update.Enabled:=True;
Button_delete.Enabled:=True;
end;

procedure TForm_harga.FormShow(Sender: TObject);
begin
bersih;
nomer_urut_berat;
tampil;
Edit_id_berat.Enabled:=False;
Button_simpan.Enabled:=True;
Button_update.Enabled:=False;
Button_delete.Enabled:=False;
end;

procedure TForm_harga.nomer_urut_berat;
var
id,idjadi, nol:string;
begin
nol:='00';
with Data_Module.ADOQuery_petugas do
begin
  SQL.Clear;
  sql.Add('select * from tb_berat order by id_berat');
  Open;
  if RecordCount > 0 then
  begin
    last;
    id:=FieldByName('id_berat').AsString;
    idjadi:=RightStr(id,1);
    id:=IntToStr(StrToInt(idjadi)+1);
    idjadi:='IDB'+leftstr(nol,2-Length(id))+id;
    Edit_id_berat.Text:=idjadi;
    end
    else
    begin
    Edit_id_berat.text:='IDB01';
    end;
    end;



end;

end.
