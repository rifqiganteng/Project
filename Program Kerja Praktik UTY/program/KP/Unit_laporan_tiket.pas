unit Unit_laporan_tiket;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.ExtCtrls, QuickRpt, QRCtrls,
  Vcl.Imaging.pngimage;

type
  TForm_laporan_tiket = class(TForm)
    QuickRep1: TQuickRep;
    QRBand1: TQRBand;
    QRBand2: TQRBand;
    QRLabel1: TQRLabel;
    QRImage1: TQRImage;
    QRShape1: TQRShape;
    QRLabel2: TQRLabel;
    QRLabel3: TQRLabel;
    QRLabel4: TQRLabel;
    QRLabel5: TQRLabel;
    QRLabel6: TQRLabel;
    QRLabel7: TQRLabel;
    QRLabel8: TQRLabel;
    QRSysData1: TQRSysData;
    QRDBText_jam: TQRDBText;
    QRDBText_nama: TQRDBText;
    QRDBText_kota_awal: TQRDBText;
    QRDBText_kota_tujuan: TQRDBText;
    QRDBText_tanggal: TQRDBText;
    QRDBText_harga: TQRDBText;
    QRBand3: TQRBand;
    QRLabel10: TQRLabel;
    QRLabel_nama_admin_tiket: TQRLabel;
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form_laporan_tiket: TForm_laporan_tiket;

implementation

{$R *.dfm}

uses Unitdatamodul;

end.
