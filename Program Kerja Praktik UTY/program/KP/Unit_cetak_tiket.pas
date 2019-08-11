unit Unit_cetak_tiket;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls, QuickRpt, QRCtrls,
  Vcl.ExtCtrls, Vcl.Imaging.pngimage, qrpctrls, Data.DB, Data.Win.ADODB;

type
  TForm_cetak_tiket = class(TForm)
    QuickRep1: TQuickRep;
    QRBand1: TQRBand;
    QRLabel1: TQRLabel;
    Label1: TLabel;
    QRBand2: TQRBand;
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
    QRLabel_ID_TIKET: TQRLabel;
    QRLabel_NAMA: TQRLabel;
    QRLabel_KOTA_TUJUAN: TQRLabel;
    QRLabel_ALAMAT_TUJUAN: TQRLabel;
    QRLabel_TGL_BERANGKAT: TQRLabel;
    QRLabel_HARGA: TQRLabel;
    QRPShape1: TQRPShape;
    QRImage1: TQRImage;
    QRLabel13: TQRLabel;
    QRnama_petugas: TQRLabel;
    ADOQuery1: TADOQuery;
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form_cetak_tiket: TForm_cetak_tiket;

implementation

{$R *.dfm}

uses Unitdatamodul;

end.
