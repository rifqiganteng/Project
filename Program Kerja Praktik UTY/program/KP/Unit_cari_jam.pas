unit Unit_cari_jam;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls, Vcl.Grids, Vcl.DBGrids;

type
  TForm_cari_jam = class(TForm)
    DBGrid_cari_jam: TDBGrid;
    Button_cari_jam: TButton;
    procedure DBGrid_cari_jamCellClick(Column: TColumn);
    procedure FormShow(Sender: TObject);
    procedure Button_cari_jamClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form_cari_jam: TForm_cari_jam;

implementation

uses
  Unitdatamodul, Unitpemberangkatan, Unittiket;

{$R *.dfm}

procedure TForm_cari_jam.Button_cari_jamClick(Sender: TObject);
begin
Form_cari_jam.Close;
end;

procedure TForm_cari_jam.DBGrid_cari_jamCellClick(Column: TColumn);
begin
with Data_Module.ADOQuery_trans_tiket do
    begin
      Form_tiket.Edit_jam.Text:=DBGrid_cari_jam.Fields[1].AsString;
      Form_tiket.Edit_id_pemberangkatan.Text:=DBGrid_cari_jam.Fields[0].AsString;
    end;
end;

procedure TForm_cari_jam.FormShow(Sender: TObject);
begin
 with Data_Module.ADOQuery_pilih_jam do
  begin
  Active:=false;
    SQL.Clear;
    SQL.Text:='select * from tb_pemberangkatan';
    Active:=true;
 end;
  Data_Module.DataSource_pilih_jam.DataSet:=Data_Module.ADOQuery_pilih_jam;
  DBGrid_cari_jam.DataSource:=Data_Module.DataSource_pilih_jam;

end;

end.
