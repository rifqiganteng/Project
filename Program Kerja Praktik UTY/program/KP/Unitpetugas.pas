unit Unitpetugas;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.Grids, Vcl.DBGrids, Vcl.ComCtrls,
  Vcl.StdCtrls;

type
  TForm_petugas = class(TForm)
    GroupBox1: TGroupBox;
    Label1: TLabel;
    Label2: TLabel;
    Label3: TLabel;
    Label4: TLabel;
    Label5: TLabel;
    Label6: TLabel;
    Label7: TLabel;
    Label8: TLabel;
    Edit_ID_petugas: TEdit;
    Edit_nama_petugas: TEdit;
    Edit_Alamat_petugas: TEdit;
    Edit_nomor_hp: TEdit;
    Edit_username: TEdit;
    Edit_pasword: TEdit;
    Button_update: TButton;
    Button_delete: TButton;
    Button_simpan: TButton;
    ComboBox_hakakses: TComboBox;
    ComboBox_jenis_kelamin: TComboBox;
    DateTimePicker_tanggal: TDateTimePicker;
    GroupBox2: TGroupBox;
    DBGrid1: TDBGrid;
    procedure Button_simpanClick(Sender: TObject);
    procedure Button_deleteClick(Sender: TObject);
    procedure Button_updateClick(Sender: TObject);
    procedure DBGrid1CellClick(Column: TColumn);
    procedure FormShow(Sender: TObject);
    procedure ComboBox_jenis_kelaminKeyPress(Sender: TObject; var Key: Char);
    procedure ComboBox_hakaksesKeyPress(Sender: TObject; var Key: Char);
  private
    { Private declarations }
    procedure bersih;
  public
    { Public declarations }
    procedure nomer_urut_petugas;
  end;

var
  Form_petugas: TForm_petugas;

implementation


uses
  Unitutama, Unitdatamodul, ADODB, DB, strutils;

{$R *.dfm}

procedure TForm_petugas.bersih;
begin
Edit_nama_petugas.Clear;
Edit_Alamat_petugas.Clear;
ComboBox_jenis_kelamin.Text:='-pilih jenis kelamin-';
Edit_nomor_hp.Clear;
Edit_username.Clear;
Edit_pasword.Clear;
ComboBox_hakakses.Text:='-pilih hak akses-';
Edit_ID_petugas.Enabled:=false;
end;


procedure TForm_petugas.DBGrid1CellClick(Column: TColumn);
begin
with Data_Module.ADOQuery_petugas do
begin
Edit_ID_petugas.Text:=FieldByName('id_petugas').AsString;
Edit_nama_petugas.Text:=FieldByName('nama').AsString;
Edit_Alamat_petugas.Text:=FieldByName('alamat').AsString;
ComboBox_jenis_kelamin.Text:=FieldByName('jk').AsString;
DateTimePicker_tanggal.Date:=FieldByName('tgl_lahir').AsDateTime;
Edit_nomor_hp.Text:=FieldByName('no_hp').AsString;
Edit_username.Text:=FieldByName('username').AsString;
Edit_pasword.Text:=FieldByName('pasword').AsString;
ComboBox_hakakses.Text:=FieldByName('hak_kses').AsString;
Button_simpan.Enabled:=False;
Button_update.Enabled:=True;
Button_delete.Enabled:=True;
end;
end;

procedure TForm_petugas.FormShow(Sender: TObject);
begin
with Data_Module.ADOQuery_petugas do
  begin
    Active:=False;
    SQL.Text:='select id_petugas, nama, alamat, jk, tgl_lahir, no_hp, username, pasword, hak_kses from tb_petugas';
    Active:=True;
  end;
Edit_ID_petugas.Clear;
Edit_nama_petugas.Clear;
Edit_Alamat_petugas.Clear;
ComboBox_jenis_kelamin.Text:='-pilih jenis kelamin-';
Edit_nomor_hp.Clear;
Edit_username.Clear;
Edit_pasword.Clear;
ComboBox_hakakses.Text:='-pilih hak akses-';
DateTimePicker_tanggal.DateTime:=now;
//DateTimePicker_tanggal.(FormatDateTime('dd/mm/yy',DateTimePicker_tanggal.Date));
nomer_urut_petugas;
Edit_ID_petugas.Enabled:=False;
Button_update.Enabled:=False;
Button_delete.Enabled:=False;
end;


procedure TForm_petugas.nomer_urut_petugas;
var
id,idjadi, nol:string;
begin
nol:='00';
with Data_Module.ADOQuery_petugas do
begin
  SQL.Clear;
  sql.Add('select * from tb_petugas order by id_petugas');
  Open;
  if RecordCount > 0 then
  begin
    last;
    id:=FieldByName('id_petugas').AsString;
    idjadi:=RightStr(id,1);
    id:=IntToStr(StrToInt(idjadi)+1);
    idjadi:='IDP'+leftstr(nol,2-Length(id))+id;
    Edit_ID_petugas.Text:=idjadi;
    end
    else
    begin
    Edit_ID_petugas.text:='IDP01';




  end;

end;

end;

procedure TForm_petugas.Button_deleteClick(Sender: TObject);
begin
 try Data_Module.ADOConnection1.BeginTrans;
  with Data_Module.ADOQuery_petugas do
    begin
      Close;
      Connection:=Data_Module.ADOConnection1;
      SQL.Text:='delete from tb_petugas where id_petugas='+QuotedStr(Edit_ID_petugas.Text);
      ExecSQL;
    end;
    Data_Module.ADOConnection1.CommitTrans;
    Application.MessageBox('Data Telah Dihapus ! ! !','INFORMASI',mb_ok+mb_iconinformation);
    except
    Data_Module.ADOConnection1.RollbackTrans;
    Application.MessageBox('Data Gagal Dihapus ! ! !','INFORMASI',mb_ok+MB_ICONERROR);
    end;
    with Data_Module.ADOQuery_petugas do
    begin
      Active:=false;
      SQl.Text:='select * from tb_petugas';
      Active:=True;
      DBGrid1.DataSource:=Data_Module.DataSource_petugas;
      Data_Module.DataSource_petugas.DataSet:=Data_Module.ADOQuery_petugas;
      bersih;
      Button_delete.Enabled:=False;
      Button_update.Enabled:=False;
      Button_simpan.Enabled:=True;
end;
end;

procedure TForm_petugas.Button_simpanClick(Sender: TObject);
begin
if (Edit_ID_petugas.Text='') or (Edit_nama_petugas.Text='') or (Edit_Alamat_petugas.Text='') or (ComboBox_jenis_kelamin.Text='-pilih jenis kelamin-') or
(Edit_nomor_hp.Text='') or (Edit_username.Text='') or (Edit_pasword.Text='') or (ComboBox_hakakses.Text='-pilih hak akses-')
then
begin
ShowMessage('Mohon isikan data dengan lengkap');
Edit_nama_petugas.SetFocus;
end
else
with Data_Module.ADOQuery_petugas do
begin
  Active:=false;
 Close;
 SQL.Clear;
 SQL.Text:='insert into tb_petugas values('+QuotedStr(Edit_ID_petugas.Text)+','+QuotedStr(Edit_nama_petugas.Text)+
 ','+QuotedStr(Edit_Alamat_petugas.Text)+','+QuotedStr(ComboBox_jenis_kelamin.Text)+','+QuotedStr(FormatDateTime('mm/dd/yy',DateTimePicker_tanggal.Date))+','+QuotedStr(Edit_nomor_hp.Text)+
 ','+QuotedStr(Edit_username.Text)+','+QuotedStr(Edit_pasword.Text)+','+QuotedStr(ComboBox_hakakses.Text)+')';
 ExecSQL;
 end;
 begin
  with Data_Module.ADOQuery_petugas do
 begin
   Active:=false;
   SQL.Text:='select*from tb_petugas';
   Active:=true;
   ExecSQL;
   bersih;
   nomer_urut_petugas;
end;
end;
end;

procedure TForm_petugas.Button_updateClick(Sender: TObject);
begin
 if(Edit_ID_petugas.Text = '')or (Edit_nama_petugas.Text = '')or(Edit_Alamat_petugas.Text = '') or (Edit_nomor_hp.Text = '') or (Edit_username.Text = '')or (Edit_pasword.Text = '')or (ComboBox_hakakses.Text = '') or (ComboBox_jenis_kelamin.Text = '') then
  begin
  ShowMessage('lengkapi data terlebih dahulu')
  end
  else
begin
 with Data_Module.ADOQuery_petugas do
  begin
    Active:=False;
    SQL.Text:='select * from tb_petugas';
    Active:=True;
  end;
  try
  Data_Module.ADOConnection1.BeginTrans;
  with Data_Module.ADOQuery_petugas do
  begin
    Active:=True;
    Close;
    SQl.Clear;
    SQl.Text:='update tb_petugas set nama='+QuotedStr(Edit_nama_petugas.Text)+
    ',alamat='+QuotedStr(Edit_Alamat_petugas.Text)+
    ',jk='+QuotedStr(ComboBox_jenis_kelamin.Text)+
    ',tgl_lahir='+QuotedStr(FormatDateTime('mm/dd/yy',DateTimePicker_tanggal.Date))+
    ',no_hp='+QuotedStr(Edit_nomor_hp.Text)+',username='+QuotedStr(Edit_username.Text)+
    ',pasword='+QuotedStr(Edit_pasword.Text)+
    ',hak_kses='+QuotedStr(ComboBox_hakakses.Text)+
    ' where id_petugas='+QuotedStr(Edit_ID_petugas.Text);
    ExecSQL;
  end;
  Data_Module.ADOConnection1.CommitTrans;
  Application.MessageBox('Data Berhasil Diubah ! ! !','INFORMASI',mb_ok+mb_iconinformation);
  except
Data_Module.ADOConnection1.RollbackTrans;
Application.MessageBox('Data Gagal Diubah ! ! !','INFORMASI',mb_ok+MB_ICONERROR);
end;
with Data_Module.ADOQuery_petugas do
begin
  Active:=False;
  SQL.Text:='select * from tb_petugas';
  Active:=True;
  DBGrid1.DataSource:=Data_Module.DataSource_petugas;
  Data_Module.DataSource_petugas.DataSet:=Data_Module.ADOQuery_petugas;

end;
ComboBox_hakakses.Enabled:=True;
  ComboBox_jenis_kelamin.Enabled:=True;
  Edit_nama_petugas.Enabled:=True;
  Edit_Alamat_petugas.Enabled:=True;
  Edit_nomor_hp.Enabled:=True;
  Edit_username.Enabled:=True;
  Edit_pasword.Enabled:=True;
  Edit_ID_petugas.Enabled:=False;
  bersih;
  nomer_urut_petugas;
      Button_delete.Enabled:=False;
      Button_update.Enabled:=False;
      Button_simpan.Enabled:=True;
end;
end;
procedure TForm_petugas.ComboBox_hakaksesKeyPress(Sender: TObject;
  var Key: Char);
begin
Key:=#0;
end;

procedure TForm_petugas.ComboBox_jenis_kelaminKeyPress(Sender: TObject;
  var Key: Char);
begin
Key:=#0;
end;

end.
