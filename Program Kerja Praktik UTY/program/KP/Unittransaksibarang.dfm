object Form_pengiriman_barang: TForm_pengiriman_barang
  Left = 0
  Top = 0
  Caption = 'Form_pengiriman_barang'
  ClientHeight = 396
  ClientWidth = 1062
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
    Width = 585
    Height = 377
    TabOrder = 0
    object Label1: TLabel
      Left = 200
      Top = 24
      Width = 218
      Height = 23
      Caption = 'PENGIRIMAN BARANG'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -19
      Font.Name = 'Tahoma'
      Font.Style = [fsBold]
      ParentFont = False
    end
    object Label2: TLabel
      Left = 20
      Top = 83
      Width = 72
      Height = 13
      Caption = 'Kode Transaksi'
    end
    object Label_petugas_pengiriman_barang: TLabel
      Left = 20
      Top = 110
      Width = 52
      Height = 13
      Caption = 'Id Petugas'
    end
    object Label4: TLabel
      Left = 260
      Top = 137
      Width = 80
      Height = 13
      Caption = 'Alamat Penerima'
    end
    object Label5: TLabel
      Left = 20
      Top = 164
      Width = 70
      Height = 13
      Caption = 'Nama Pengirim'
    end
    object Label6: TLabel
      Left = 20
      Top = 274
      Width = 25
      Height = 13
      Caption = 'CARI'
    end
    object Label7: TLabel
      Left = 20
      Top = 245
      Width = 58
      Height = 13
      Caption = 'Kota Tujuan'
    end
    object Label8: TLabel
      Left = 260
      Top = 110
      Width = 76
      Height = 13
      Caption = 'Alamat Pengirim'
    end
    object Label10: TLabel
      Left = 260
      Top = 164
      Width = 103
      Height = 13
      Caption = 'No Telephon Pengirim'
    end
    object Label11: TLabel
      Left = 260
      Top = 191
      Width = 107
      Height = 13
      Caption = 'No Telephon Penerima'
    end
    object Label12: TLabel
      Left = 330
      Top = 336
      Width = 55
      Height = 13
      Caption = 'Total harga'
    end
    object Label13: TLabel
      Left = 20
      Top = 191
      Width = 74
      Height = 13
      Caption = 'Nama Penerima'
    end
    object Label14: TLabel
      Left = 260
      Top = 83
      Width = 36
      Height = 13
      Caption = 'Id Jalur'
    end
    object Label15: TLabel
      Left = 260
      Top = 218
      Width = 39
      Height = 13
      Caption = 'kategori'
    end
    object Label16: TLabel
      Left = 260
      Top = 245
      Width = 26
      Height = 13
      Caption = 'berat'
    end
    object Label3: TLabel
      Left = 20
      Top = 218
      Width = 48
      Height = 13
      Caption = 'Kota Awal'
    end
    object Label9: TLabel
      Left = 20
      Top = 137
      Width = 64
      Height = 13
      Caption = 'Nama Barang'
    end
    object Label17: TLabel
      Left = 259
      Top = 274
      Width = 130
      Height = 13
      Caption = 'Tanggal Pengiriman Barang'
    end
    object Edit_pengiriman_barang: TEdit
      Left = 120
      Top = 80
      Width = 121
      Height = 21
      TabOrder = 0
      Text = 'Edit_pengiriman_barang'
    end
    object Edit_petugas_pengiriman_barang: TEdit
      Left = 120
      Top = 107
      Width = 121
      Height = 21
      TabOrder = 1
      Text = 'Edit_petugas_pengiriman_barang'
    end
    object Edit_nama_barang: TEdit
      Left = 120
      Top = 134
      Width = 121
      Height = 21
      TabOrder = 2
      Text = 'Edit_nama_barang'
    end
    object Edit_nama_pengirim_barang: TEdit
      Left = 120
      Top = 161
      Width = 121
      Height = 21
      TabOrder = 3
      Text = 'Edit_nama_pengirim_barang'
    end
    object Edit_alamat_pengirim_barang: TEdit
      Left = 400
      Top = 107
      Width = 121
      Height = 21
      TabOrder = 4
      Text = 'Edit_alamat_pengirim_barang'
    end
    object Edit8_alamat_penerima_barang: TEdit
      Left = 400
      Top = 134
      Width = 121
      Height = 21
      TabOrder = 5
      Text = 'Edit8_alamat_penerima_barang'
    end
    object Edit_nomor_telepon_pengirim: TEdit
      Left = 400
      Top = 161
      Width = 121
      Height = 21
      TabOrder = 6
      Text = 'Edit_nomor_telepon_pengirim'
      OnKeyPress = Edit_nomor_telepon_pengirimKeyPress
    end
    object Edit_nomor_telephon_penerima: TEdit
      Left = 400
      Top = 188
      Width = 121
      Height = 21
      TabOrder = 7
      Text = 'Edit_nomor_telephon_penerima'
      OnKeyPress = Edit_nomor_telephon_penerimaKeyPress
    end
    object Edit_total_harga_pengiriman_barang: TEdit
      Left = 400
      Top = 333
      Width = 121
      Height = 21
      Enabled = False
      TabOrder = 8
      Text = 'Edit_total_harga_pengiriman_barang'
    end
    object Button_simpan_pengiriman_barang: TButton
      Left = 20
      Top = 331
      Width = 75
      Height = 25
      Caption = 'SIMPAN'
      TabOrder = 9
      OnClick = Button_simpan_pengiriman_barangClick
    end
    object Button_reset_pengiriman_barang: TButton
      Left = 120
      Top = 331
      Width = 75
      Height = 25
      Caption = 'RESET'
      TabOrder = 10
      OnClick = Button_reset_pengiriman_barangClick
    end
    object Edit_nama_penerima_barang: TEdit
      Left = 120
      Top = 188
      Width = 121
      Height = 21
      TabOrder = 11
      Text = 'Edit_nama_penerima_barang'
    end
    object Button_cari_jalur: TButton
      Left = 120
      Top = 269
      Width = 121
      Height = 25
      Caption = 'CALI JALUR'
      TabOrder = 12
      OnClick = Button_cari_jalurClick
    end
    object Edit_jalur_barang: TEdit
      Left = 400
      Top = 80
      Width = 121
      Height = 21
      Enabled = False
      TabOrder = 13
      Text = 'Edit_jalur_barang'
    end
    object Edit_kota_tujuan: TEdit
      Left = 120
      Top = 242
      Width = 121
      Height = 21
      Enabled = False
      TabOrder = 14
      Text = 'Edit_kota_tujuan'
    end
    object Edit_kota_awal: TEdit
      Left = 120
      Top = 215
      Width = 121
      Height = 21
      Enabled = False
      TabOrder = 15
      Text = 'Edit_kota_awal'
    end
    object ComboBox_berat_barang: TComboBox
      Left = 400
      Top = 242
      Width = 121
      Height = 21
      TabOrder = 16
      Text = 'ComboBox_berat_barang'
      OnChange = ComboBox_berat_barangChange
      OnKeyPress = ComboBox_berat_barangKeyPress
    end
    object edHrgTujuan: TEdit
      Left = 20
      Top = 304
      Width = 121
      Height = 21
      TabOrder = 17
      Text = '0'
      Visible = False
    end
    object edHrgKategori: TEdit
      Left = 147
      Top = 304
      Width = 121
      Height = 21
      TabOrder = 18
      Text = '0'
      Visible = False
    end
    object edHrgBerat: TEdit
      Left = 274
      Top = 306
      Width = 121
      Height = 21
      TabOrder = 19
      Text = '0'
      Visible = False
    end
    object DateTimePicker_pengiriman_barang: TDateTimePicker
      Left = 395
      Top = 269
      Width = 122
      Height = 21
      Date = 42400.589250300920000000
      Time = 42400.589250300920000000
      TabOrder = 20
      OnChange = DateTimePicker_pengiriman_barangChange
    end
  end
  object Panel2: TPanel
    Left = 599
    Top = 8
    Width = 455
    Height = 377
    Caption = 'Panel2'
    TabOrder = 1
    object DBGrid_pengiriman_barang: TDBGrid
      Left = 0
      Top = 0
      Width = 441
      Height = 361
      DataSource = Data_Module.DataSource_untuk_tampil_barang
      PopupMenu = PopupMenu1
      TabOrder = 0
      TitleFont.Charset = DEFAULT_CHARSET
      TitleFont.Color = clWindowText
      TitleFont.Height = -11
      TitleFont.Name = 'Tahoma'
      TitleFont.Style = []
      OnCellClick = DBGrid_pengiriman_barangCellClick
    end
  end
  object ComboBox_kategori_barang: TComboBox
    Left = 408
    Top = 223
    Width = 121
    Height = 21
    TabOrder = 2
    OnChange = ComboBox_kategori_barangChange
    OnKeyPress = ComboBox_kategori_barangKeyPress
  end
  object ADOQuery_khusus_jenis_barang: TADOQuery
    Connection = Data_Module.ADOConnection1
    Parameters = <>
    Left = 104
    Top = 16
  end
  object ADOQuery_khusus_beratbarang: TADOQuery
    Connection = Data_Module.ADOConnection1
    Parameters = <>
    Left = 512
    Top = 16
  end
  object PopupMenu1: TPopupMenu
    Left = 544
    Top = 296
    object CETAK1: TMenuItem
      Caption = 'CETAK'
      OnClick = CETAK1Click
    end
  end
end
