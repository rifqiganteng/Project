object Form_tiket: TForm_tiket
  Left = 0
  Top = 0
  Caption = 'Form_tiket'
  ClientHeight = 411
  ClientWidth = 1172
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  OldCreateOrder = False
  OnShow = FormShow
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel
    Left = 8
    Top = 8
    Width = 569
    Height = 399
    TabOrder = 0
    object Label1: TLabel
      Left = 203
      Top = 24
      Width = 185
      Height = 23
      Caption = 'PEMESANAN TIKET'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -19
      Font.Name = 'Tahoma'
      Font.Style = [fsBold]
      ParentFont = False
    end
    object Label2: TLabel
      Left = 14
      Top = 88
      Width = 98
      Height = 13
      Caption = 'Kode Transaksi Tiket'
    end
    object Label3: TLabel
      Left = 15
      Top = 115
      Width = 52
      Height = 13
      Caption = 'Id Petugas'
    end
    object Label4: TLabel
      Left = 16
      Top = 142
      Width = 73
      Height = 13
      Caption = 'Nama Pemesan'
    end
    object Label5: TLabel
      Left = 14
      Top = 169
      Width = 78
      Height = 13
      Caption = 'Nomer Telephon'
    end
    object Label6: TLabel
      Left = 293
      Top = 141
      Width = 71
      Height = 13
      Caption = 'Alamat Jemput'
    end
    object Label7: TLabel
      Left = 293
      Top = 169
      Width = 69
      Height = 13
      Caption = 'Alamat Tujuan'
    end
    object Label8: TLabel
      Left = 16
      Top = 255
      Width = 36
      Height = 13
      Caption = 'Id Jalur'
    end
    object Label9: TLabel
      Left = 14
      Top = 196
      Width = 51
      Height = 13
      Caption = 'Kota Awal '
    end
    object Label10: TLabel
      Left = 15
      Top = 223
      Width = 58
      Height = 13
      Caption = 'Kota Tujuan'
    end
    object Label12: TLabel
      Left = 293
      Top = 254
      Width = 96
      Height = 13
      Caption = 'Jumlah pembayaran'
    end
    object Label13: TLabel
      Left = 293
      Top = 88
      Width = 71
      Height = 13
      Caption = 'Jam Berangkat'
    end
    object Label11: TLabel
      Left = 293
      Top = 116
      Width = 95
      Height = 13
      Caption = 'id_pemberangkatan'
    end
    object TLabel
      Left = 284
      Top = 191
      Width = 3
      Height = 13
    end
    object Label14: TLabel
      Left = 293
      Top = 196
      Width = 96
      Height = 13
      Caption = 'Tanggal pemesanan'
    end
    object Label15: TLabel
      Left = 293
      Top = 223
      Width = 90
      Height = 13
      Caption = 'Tanggal Berangkat'
    end
    object Edit_pemesanan_tiket: TEdit
      Left = 128
      Top = 85
      Width = 150
      Height = 21
      TabOrder = 0
      Text = 'Edit_pemesanan_tiket'
    end
    object Edit_petugas_pemesanan_tiket: TEdit
      Left = 128
      Top = 112
      Width = 150
      Height = 21
      TabOrder = 1
      Text = 'Edit_petugas_pemesanan_tiket'
    end
    object Edit_nama_pemesan: TEdit
      Left = 128
      Top = 139
      Width = 150
      Height = 21
      TabOrder = 2
      Text = 'Edit_nama_pemesan'
    end
    object Edit_no_telepon_pemesan: TEdit
      Left = 128
      Top = 166
      Width = 150
      Height = 21
      TabOrder = 3
      Text = 'Edit_no_telepon_pemesan'
      OnKeyPress = Edit_no_telepon_pemesanKeyPress
    end
    object Edit_alamat_jemput: TEdit
      Left = 408
      Top = 140
      Width = 151
      Height = 21
      TabOrder = 4
      Text = 'Edit_alamat_jemput'
    end
    object Editalamat_tujuan: TEdit
      Left = 408
      Top = 167
      Width = 151
      Height = 21
      TabOrder = 5
      Text = 'Editalamat_tujuan'
    end
    object Edit_jumlah_pembayaran: TEdit
      Left = 408
      Top = 248
      Width = 152
      Height = 21
      Enabled = False
      TabOrder = 6
      Text = 'Edit_jumlah_pembayaran'
    end
    object Button_simpan_pemesanan_tiket: TButton
      Left = 16
      Top = 336
      Width = 81
      Height = 33
      Caption = 'SIMPAN'
      TabOrder = 7
      OnClick = Button_simpan_pemesanan_tiketClick
    end
    object Button_reset_pemesanan_tiket: TButton
      Left = 112
      Top = 336
      Width = 81
      Height = 33
      Caption = 'RESET'
      TabOrder = 8
      OnClick = Button_reset_pemesanan_tiketClick
    end
    object Edit_jalur: TEdit
      Left = 128
      Top = 252
      Width = 105
      Height = 21
      Enabled = False
      TabOrder = 9
      Text = 'Edit_jalur'
    end
    object Button_cari_jalur: TButton
      Left = 237
      Top = 251
      Width = 41
      Height = 25
      Caption = 'CARI'
      TabOrder = 10
      OnClick = Button_cari_jalurClick
    end
    object Button_cari_jam: TButton
      Left = 519
      Top = 83
      Width = 41
      Height = 25
      Caption = 'CARI'
      TabOrder = 11
      OnClick = Button_cari_jamClick
    end
    object Edit_jam: TEdit
      Left = 408
      Top = 85
      Width = 105
      Height = 21
      Enabled = False
      TabOrder = 12
      Text = 'Edit_jam'
    end
    object Edit_id_pemberangkatan: TEdit
      Left = 408
      Top = 113
      Width = 152
      Height = 21
      Enabled = False
      TabOrder = 13
      Text = 'Edit_id_pemberangkatan'
    end
    object DateTimePicker_pemesanan: TDateTimePicker
      Left = 408
      Top = 194
      Width = 151
      Height = 21
      Date = 42400.005016469910000000
      Time = 42400.005016469910000000
      TabOrder = 14
      OnChange = DateTimePicker_pemesananChange
    end
    object DateTimePicker_pemberangkatan: TDateTimePicker
      Left = 408
      Top = 221
      Width = 152
      Height = 21
      Date = 42400.006856574070000000
      Time = 42400.006856574070000000
      TabOrder = 15
    end
    object Edit_kota_awal: TEdit
      Left = 128
      Top = 193
      Width = 149
      Height = 21
      Enabled = False
      TabOrder = 16
      Text = 'Edit_kota_awal'
    end
    object Edit_kota_tujuan: TEdit
      Left = 128
      Top = 220
      Width = 149
      Height = 21
      Enabled = False
      TabOrder = 17
      Text = 'Edit_kota_tujuan'
    end
  end
  object Panel2: TPanel
    Left = 583
    Top = 8
    Width = 586
    Height = 399
    TabOrder = 1
    object DBGrid_pemesanan_tiket: TDBGrid
      Left = 8
      Top = 8
      Width = 569
      Height = 385
      ParentShowHint = False
      PopupMenu = PopupMenu1
      ShowHint = False
      TabOrder = 0
      TitleFont.Charset = DEFAULT_CHARSET
      TitleFont.Color = clWindowText
      TitleFont.Height = -11
      TitleFont.Name = 'Tahoma'
      TitleFont.Style = []
      OnCellClick = DBGrid_pemesanan_tiketCellClick
      OnDblClick = DBGrid_pemesanan_tiketDblClick
    end
  end
  object PopupMenu1: TPopupMenu
    Left = 512
    Top = 344
    object CETAK1: TMenuItem
      Caption = 'CETAK'
      OnClick = CETAK1Click
    end
  end
end
