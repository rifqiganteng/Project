unit Unitpemberangkatan;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.Grids, Vcl.DBGrids, Vcl.StdCtrls;

type
  TForm_pemberangkatan = class(TForm)
    GroupBox1: TGroupBox;
    Label1: TLabel;
    Label3: TLabel;
    Edit_id_pemberangkatan: TEdit;
    Button_update_pemberangkatan: TButton;
    Button_delete_pemberangkatan: TButton;
    Button_simpan_pemberangkatan: TButton;
    Edit_jam_pemberangkatan: TEdit;
    GroupBox2: TGroupBox;
    DBGrid1: TDBGrid;
    procedure Button_simpan_pemberangkatanClick(Sender: TObject);
    procedure FormShow(Sender: TObject);
    procedure DBGrid1CellClick(Column: TColumn);
    procedure Button_delete_pemberangkatanClick(Sender: TObject);
    procedure Button_update_pemberangkatanClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
    procedure nomer_urut_pemberangkatan;
    procedure bersih;

  end;

var
  Form_pemberangkatan: TForm_pemberangkatan;

implementation

uses
  Unitutama, Unitdatamodul, strutils;

{$R *.dfm}


procedure TForm_pemberangkatan.bersih;
begin
Edit_id_pemberangkatan.Clear;
Edit_jam_pemberangkatan.Clear;

end;

procedure TForm_pemberangkatan.Button_delete_pemberangkatanClick(
  Sender: TObject);
begin
try Data_Module.ADOConnection1.BeginTrans;
  with Data_Module.ADOQuery_pemberangkatan do
    begin
      Close;
      Connection:=Data_Module.ADOConnection1;
      SQL.Text:='delete from tb_pemberangkatan where id_pemberangkatan='+QuotedStr(Edit_id_pemberangkatan.Text);
      ExecSQL;
    end;
    Data_Module.ADOConnection1.CommitTrans;
    Application.MessageBox('Data Telah Dihapus ! ! !','INFORMASI',mb_ok+mb_iconinformation);
    bersih;
    nomer_urut_pemberangkatan;
    Button_simpan_pemberangkatan.Enabled:=True;
    Button_update_pemberangkatan.Enabled:=False;
    Button_delete_pemberangkatan.Enabled:=False;
    except
    Data_Module.ADOConnection1.RollbackTrans;
    Application.MessageBox('Data Gagal Dihapus ! ! !','INFORMASI',mb_ok+MB_ICONERROR);
    end;
    with Data_Module.ADOQuery_pemberangkatan do
    begin
      Active:=false;
      SQl.Text:='select * from tb_pemberangkatan';
      Active:=True;
      DBGrid1.DataSource:=Data_Module.DataSource_pemberangkatan;
      Data_Module.DataSource_pemberangkatan.DataSet:=Data_Module.ADOQuery_pemberangkatan;
Edit_jam_pemberangkatan.Clear;
end;
end;

procedure TForm_pemberangkatan.Button_simpan_pemberangkatanClick(
  Sender: TObject);
begin
if (Edit_id_pemberangkatan.Text='') or (Edit_jam_pemberangkatan.Text='')
then
begin
ShowMessage('Mohon isikan data dengan lengkap');
Edit_jam_pemberangkatan.SetFocus;
end
else
with Data_Module.ADOQuery_pemberangkatan do
begin
  Active:=false;
 Close;
 SQL.Clear;
 SQL.Text:='insert into tb_pemberangkatan values('+QuotedStr(Edit_id_pemberangkatan.Text)+
 ','+QuotedStr(Edit_jam_pemberangkatan.Text)+')';
 ExecSQL;
 ShowMessage('data berhasil disimpan');
 end;
 Edit_id_pemberangkatan.Clear;
 Edit_jam_pemberangkatan.Clear;
 nomer_urut_pemberangkatan;
 begin
  with Data_Module.ADOQuery_pemberangkatan do
 begin
   Active:=false;
   SQL.Text:='select * from tb_pemberangkatan';
   Active:=true;
   ExecSQL;
   //bersih;
end;
end;
end;

procedure TForm_pemberangkatan.Button_update_pemberangkatanClick(
  Sender: TObject);
begin
 if(Edit_id_pemberangkatan.Text = '') or (Edit_jam_pemberangkatan.Text = '') then
  begin
  ShowMessage('lengkapi data terlebih dahulu')
  end
  else
  begin
 with Data_Module.ADOQuery_pemberangkatan do
  begin
    Active:=False;
    SQL.Text:='select * from tb_pemberangkatan';
    Active:=True;
  end;
  try
  Data_Module.ADOConnection1.BeginTrans;
  with Data_Module.ADOQuery_pemberangkatan do
  begin
    Active:=True;
    Close;
    SQl.Clear;
    SQl.Text:='update tb_pemberangkatan set jam_berangkat='+QuotedStr(Edit_jam_pemberangkatan.Text)+' where id_pemberangkatan='+QuotedStr(Edit_id_pemberangkatan.Text);
    ExecSQL;
  end;
  Data_Module.ADOConnection1.CommitTrans;
  Application.MessageBox('Data Berhasil Diubah ! ! !','INFORMASI',mb_ok+mb_iconinformation);
  bersih;
  nomer_urut_pemberangkatan;
  Button_simpan_pemberangkatan.Enabled:=True;
  Button_update_pemberangkatan.Enabled:=False;
  Button_delete_pemberangkatan.Enabled:=False;

  except
Data_Module.ADOConnection1.RollbackTrans;
Application.MessageBox('Data Gagal Diubah ! ! !','INFORMASI',mb_ok+MB_ICONERROR);
end;
with Data_Module.ADOQuery_pemberangkatan do
begin
  Active:=False;
  SQL.Text:='select * from tb_pemberangkatan';
  Active:=True;
  DBGrid1.DataSource:=Data_Module.DataSource_pemberangkatan;
  Data_Module.DataSource_pemberangkatan.DataSet:=Data_Module.ADOQuery_pemberangkatan;

end;
Edit_jam_pemberangkatan.Clear;

  Edit_jam_pemberangkatan.Enabled:=True;

end;
end;

procedure TForm_pemberangkatan.DBGrid1CellClick(Column: TColumn);
begin
with Data_Module.ADOQuery_pemberangkatan do
begin
Edit_id_pemberangkatan.Text:=FieldValues['id_pemberangkatan'];
Edit_jam_pemberangkatan.Text:=FieldValues['jam_berangkat'];
Button_update_pemberangkatan.Enabled:=True;
Button_delete_pemberangkatan.Enabled:=True;
Button_simpan_pemberangkatan.Enabled:=False;
end;
end;

procedure TForm_pemberangkatan.FormShow(Sender: TObject);
begin
with Data_Module.ADOQuery_pemberangkatan do
begin
    Active:=False;
    SQL.Text:='select * from tb_pemberangkatan';
    Active:=True;
  end;
Edit_id_pemberangkatan.Clear;
Edit_jam_pemberangkatan.Text:='';
nomer_urut_pemberangkatan;
Button_simpan_pemberangkatan.Enabled:=True;
Button_update_pemberangkatan.Enabled:=False;
Button_delete_pemberangkatan.Enabled:=false;

end;

procedure TForm_pemberangkatan.nomer_urut_pemberangkatan;
var
id,idjadi, nol:string;
begin
nol:='00';
with Data_Module.ADOQuery_pemberangkatan do
begin
  SQL.Clear;
  sql.Add('select * from tb_pemberangkatan order by id_pemberangkatan');
  Open;
  if RecordCount > 0 then
  begin
    last;
    id:=FieldByName('id_pemberangkatan').AsString;
    idjadi:=RightStr(id,1);
    id:=IntToStr(StrToInt(idjadi)+1);
    idjadi:='IDB'+leftstr(nol,2-Length(id))+id;
    Edit_id_pemberangkatan.Text:=idjadi;
    end
    else
    begin
    Edit_id_pemberangkatan.text:='IDB01';
    end;
end;



end;

end.
