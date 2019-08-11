unit Unit_laporan_barang;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.ExtCtrls, QuickRpt, QRCtrls,
  Vcl.StdCtrls, Data.DB, Data.Win.ADODB, qrpctrls, Vcl.Imaging.pngimage;

type
  TForm_laporan_barang = class(TForm)
    QuickRep1: TQuickRep;
    QRLabel1: TQRLabel;
    QRLabel2: TQRLabel;
    QRLabel3: TQRLabel;
    QRLabel4: TQRLabel;
    QRBand1: TQRBand;
    QRSysData1: TQRSysData;
    QRDBText_jenis: TQRDBText;
    QRImage1: TQRImage;
    QRPShape1: TQRPShape;
    QRLabel5: TQRLabel;
    QRLabel6: TQRLabel;
    QRLabel7: TQRLabel;
    QRLabel8: TQRLabel;
    QRLabel9: TQRLabel;
    QRDBText_pengirim: TQRDBText;
    QRDBText_penerima: TQRDBText;
    QRDBText_alamat_pengirim: TQRDBText;
    QRDBText_tanggal: TQRDBText;
    QRDBText_harga: TQRDBText;
    QRDBText_nama: TQRDBText;
    QRBand2: TQRBand;
    QRLabel11: TQRLabel;
    QRLabel_nama_admin_barang: TQRLabel;
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form_laporan_barang: TForm_laporan_barang;

implementation

{$R *.dfm}

uses Unitutama, Unit_form_login_baru;

end.
