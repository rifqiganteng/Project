unit Unit_cetak_barang;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, QuickRpt, QRCtrls, Vcl.ExtCtrls,
  grimgctrl, Vcl.Imaging.pngimage, Data.DB, Data.Win.ADODB;

type
  TForm_cetak_barang = class(TForm)
    QuickRep1: TQuickRep;
    QRBand1: TQRBand;
    QRBand2: TQRBand;
    QRLabel1: TQRLabel;
    QRLabel2: TQRLabel;
    QRLabel3: TQRLabel;
    QRLabel4: TQRLabel;
    QRLabel5: TQRLabel;
    QRLabel6: TQRLabel;
    QRLabel7: TQRLabel;
    QRLabel8: TQRLabel;
    QRLabel9: TQRLabel;
    QRLabel10: TQRLabel;
    QRLabel11: TQRLabel;
    QRLabel12: TQRLabel;
    QRLabel13: TQRLabel;
    QRLabel_ID_PENGIRIMAN: TQRLabel;
    QRLabel_NAMA_PENGIRIM: TQRLabel;
    QRLabel_NAMA_PENERIMA: TQRLabel;
    QRLabel_ALAMAT_TUJUAN: TQRLabel;
    QRLabel_TANGGAL_PENGIRIMAN: TQRLabel;
    QRLabel_TOTAL_HARGA: TQRLabel;
    QRLabel14: TQRLabel;
    QRLabel15: TQRLabel;
    QRLabel_NAMA_BARANG: TQRLabel;
    QRHRule1: TQRHRule;
    QRGrImage1: TQRGrImage;
    PETUGAS: TQRLabel;
    ADOQuery1: TADOQuery;
    QRnmptgs: TQRLabel;
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form_cetak_barang: TForm_cetak_barang;

implementation

{$R *.dfm}

uses Unitdatamodul;

end.
