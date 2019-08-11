unit Unitjalur;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.Grids, Vcl.DBGrids, Vcl.StdCtrls;

type
  TForm_jalur = class(TForm)
    GroupBox1: TGroupBox;
    Label1: TLabel;
    Label2: TLabel;
    Label3: TLabel;
    Edit_id_jalur: TEdit;
    Edit_harga: TEdit;
    Button_update_jalur: TButton;
    Button_delete_jalur: TButton;
    Button_simpan_jalur: TButton;
    Edit_kota_awal: TEdit;
    Edit_kota_tujuan: TEdit;
    GroupBox2: TGroupBox;
    DBGrid1: TDBGrid;
    procedure Button_simpan_jalurClick(Sender: TObject);
    procedure FormShow(Sender: TObject);
    procedure Button_update_jalurClick(Sender: TObject);
    procedure DBGrid1CellClick(Column: TColumn);
    procedure Button_delete_jalurClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
    procedure nomer_urut_jalur;
    procedure bersih;
  end;

var
  Form_jalur: TForm_jalur;

implementation

uses Unitdatamodul, strutils;

{$R *.dfm}



procedure TForm_jalur.bersih;
begin
 Edit_id_jalur.Clear;
Edit_harga.Clear;
Edit_kota_awal.Clear;
Edit_kota_tujuan.Clear;
end;

procedure TForm_jalur.Button_delete_jalurClick(Sender: TObject);
begin
try Data_Module.ADOConnection1.BeginTrans;
  with Data_Module.ADOQuery_jalur do
    begin
      Close;
      Connection:=Data_Module.ADOConnection1;
      SQL.Text:='delete from tb_jalur where id_jalur='+QuotedStr(Edit_id_jalur.Text);
      ExecSQL;
    end;
    Data_Module.ADOConnection1.CommitTrans;
    Application.MessageBox('Data Telah Dihapus ! ! !','INFORMASI',mb_ok+mb_iconinformation);
    bersih;
    nomer_urut_jalur;
    Button_simpan_jalur.Enabled:=True;
    Button_delete_jalur.Enabled:=False;
    Button_update_jalur.Enabled:=False;

    except
    Data_Module.ADOConnection1.RollbackTrans;
    Application.MessageBox('Data Gagal Dihapus ! ! !','INFORMASI',mb_ok+MB_ICONERROR);
    end;
    with Data_Module.ADOQuery_jalur do
    begin
      Active:=false;
      SQl.Text:='select * from tb_jalur';
      Active:=True;
      DBGrid1.DataSource:=Data_Module.DataSource_jalur;
      Data_Module.DataSource_jalur.DataSet:=Data_Module.ADOQuery_jalur;
end;

end;

procedure TForm_jalur.Button_simpan_jalurClick(Sender: TObject);
begin
if (Edit_id_jalur.Text='') or (Edit_kota_awal.Text='-pilih kota awal-') or (Edit_kota_tujuan.Text='-pilih kota tujuan-') or
(Edit_harga.Text='')
then
begin
ShowMessage('Mohon isikan data dengan lengkap');
end
else
with Data_Module.ADOQuery_jalur do
begin
  Active:=false;
 Close;
 SQL.Clear;
 SQL.Text:='insert into tb_jalur values('+QuotedStr(Edit_id_jalur.Text)+','+QuotedStr(Edit_kota_awal.Text)+
 ','+QuotedStr(Edit_kota_tujuan.Text)+','+QuotedStr(Edit_harga.Text)+')';
 ExecSQL;
 ShowMessage('data berhasil disimpan');
 bersih;
 nomer_urut_jalur;
 end;
 begin
  with Data_Module.ADOQuery_jalur do
 begin
   Active:=false;
   SQL.Text:='select * from tb_jalur';
   Active:=true;
   ExecSQL;
   //bersih;
end;
end;
end;

procedure TForm_jalur.Button_update_jalurClick(Sender: TObject);
begin
 if(Edit_id_jalur.Text = '')or (Edit_kota_awal.Text = '')or(Edit_kota_tujuan.Text = '') or (Edit_harga.Text = '') then
  begin
  ShowMessage('lengkapi data terlebih dahulu')
  end
  else
  begin
with Data_Module.ADOQuery_jalur do
  begin
    Active:=False;
    SQL.Text:='select * from tb_jalur';
    Active:=True;
  end;
  try
  Data_Module.ADOConnection1.BeginTrans;
  with Data_Module.ADOQuery_jalur do
  begin
    Active:=True;
    Close;
    SQl.Clear;
    SQl.Text:='update tb_jalur set kota_awal='+QuotedStr(Edit_kota_awal.Text)+',kota_tujuan='+QuotedStr(Edit_kota_tujuan.Text)+',harga='+QuotedStr(Edit_harga.Text)+'  where id_jalur='+QuotedStr(Edit_id_jalur.Text);
    ExecSQL;
  end;
  Data_Module.ADOConnection1.CommitTrans;
  Application.MessageBox('Data Berhasil Diubah ! ! !','INFORMASI',mb_ok+mb_iconinformation);
  bersih;
  nomer_urut_jalur;
Button_simpan_jalur.Enabled:=True;
Button_update_jalur.Enabled:=False;
Button_delete_jalur.Enabled:=False;
  except
Data_Module.ADOConnection1.RollbackTrans;
Application.MessageBox('Data Gagal Diubah ! ! !','INFORMASI',mb_ok+MB_ICONERROR);
end;
end;
with Data_Module.ADOQuery_jalur do
begin
  Active:=False;
  SQL.Text:='select * from tb_jalur';
  Active:=True;
  DBGrid1.DataSource:=Data_Module.DataSource_jalur;
  Data_Module.DataSource_jalur.DataSet:=Data_Module.ADOQuery_jalur;

end;

  Edit_kota_awal.Enabled:=True;
  Edit_kota_tujuan.Enabled:=True;
  Edit_harga.Enabled:=True;
  Edit_id_jalur.Enabled:=False;

end;

procedure TForm_jalur.DBGrid1CellClick(Column: TColumn);
begin
with Data_Module.ADOQuery_jalur do
begin
Edit_id_jalur.Text:=FieldValues['id_jalur'];
Edit_harga.Text:=FieldValues['harga'];
Edit_kota_awal.Text:=FieldValues['kota_awal'];
Edit_kota_tujuan.Text:=FieldValues['kota_tujuan'];
Button_simpan_jalur.Enabled:=False;
Button_update_jalur.Enabled:=True;
Button_delete_jalur.Enabled:=True;
end;
end;

procedure TForm_jalur.FormShow(Sender: TObject);
begin
with Data_Module.ADOQuery_jalur do
  begin
    Active:=False;
    SQL.Text:='select * from tb_jalur';
    Active:=True;
  end;
Edit_id_jalur.Enabled:=False;
Edit_id_jalur.clear;
Edit_harga.Clear;
Edit_kota_awal.Text:='';
Edit_kota_tujuan.Text:='';
nomer_urut_jalur;
Button_simpan_jalur.Enabled:=True;
Button_update_jalur.Enabled:=False;
Button_delete_jalur.Enabled:=false
end;

procedure TForm_jalur.nomer_urut_jalur;
var
id,idjadi, nol:string;
begin
nol:='00';
with Data_Module.ADOQuery_petugas do
begin
  SQL.Clear;
  sql.Add('select * from tb_jalur order by id_jalur');
  Open;
  if RecordCount > 0 then
  begin
    last;
    id:=FieldByName('id_jalur').AsString;
    idjadi:=RightStr(id,1);
    id:=IntToStr(StrToInt(idjadi)+1);
    idjadi:='IDJ'+leftstr(nol,2-Length(id))+id;
    Edit_id_jalur.Text:=idjadi;
    end
    else
    begin
    Edit_id_jalur.text:='IDJ01';
    end;
    end;




end;

end.

