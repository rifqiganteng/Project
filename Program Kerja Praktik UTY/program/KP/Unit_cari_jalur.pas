unit Unit_cari_jalur;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls, Vcl.Grids, Vcl.DBGrids;

type
  TForm_cari_jalur = class(TForm)
    DBGrid_cari_jalur: TDBGrid;
    Button_pilih_cari_jalur: TButton;
    procedure Button_pilih_cari_jalurClick(Sender: TObject);
    procedure DBGrid_cari_jalurCellClick(Column: TColumn);
    procedure FormShow(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form_cari_jalur: TForm_cari_jalur;

implementation


uses
  Unitdatamodul, Unittiket, ADODB, Unittransaksibarang;

{$R *.dfm}


procedure TForm_cari_jalur.Button_pilih_cari_jalurClick(Sender: TObject);
begin
 Form_cari_jalur.Close;
end;

procedure TForm_cari_jalur.DBGrid_cari_jalurCellClick(Column: TColumn);
begin
with Data_Module.ADOQuery_trans_tiket do
    begin
      Form_tiket.Edit_jalur.Text:=DBGrid_cari_jalur.Fields[0].AsString;
      Form_tiket.Edit_kota_awal.Text:=DBGrid_cari_jalur.Fields[1].AsString;
      Form_tiket.Edit_kota_tujuan.Text:=DBGrid_cari_jalur.Fields[2].AsString;
      Form_tiket.Edit_jumlah_pembayaran.Text:=DBGrid_cari_jalur.Fields[3].AsString;
      Form_pengiriman_barang.Edit_jalur_barang.Text:=DBGrid_cari_jalur.Fields[0].AsString;
      Form_pengiriman_barang.Edit_total_harga_pengiriman_barang.Text:=DBGrid_cari_jalur.Fields[3].AsString;
      Form_pengiriman_barang.Edit_kota_awal.Text:=DBGrid_cari_jalur.Fields[1].AsString;
      Form_pengiriman_barang.Edit_kota_tujuan.Text:=DBGrid_cari_jalur.Fields[2].AsString;
    end;
    Form_pengiriman_barang.edHrgTujuan.Text:=Form_pengiriman_barang.Edit_total_harga_pengiriman_barang.Text;
end;

procedure TForm_cari_jalur.FormShow(Sender: TObject);
begin
with Data_Module.ADOQuery_jalur do
begin
  Active:=False;
  Close;
  SQL.Clear;
  SQL.Text :=' select * from tb_jalur';
  active:=true;

end;
end;

end.
