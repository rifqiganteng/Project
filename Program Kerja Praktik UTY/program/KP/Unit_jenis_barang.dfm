object Form_jenis_barang: TForm_jenis_barang
  Left = 0
  Top = 0
  Caption = 'Form_jenis_barang'
  ClientHeight = 336
  ClientWidth = 773
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
    Width = 265
    Height = 313
    TabOrder = 0
    object Label1: TLabel
      Left = 24
      Top = 24
      Width = 37
      Height = 13
      Caption = 'Id Jenis'
    end
    object Label3: TLabel
      Left = 24
      Top = 88
      Width = 29
      Height = 13
      Caption = 'Harga'
    end
    object Label2: TLabel
      Left = 24
      Top = 58
      Width = 61
      Height = 13
      Caption = 'Jenis Barang'
    end
    object Edit_id_jenis: TEdit
      Left = 96
      Top = 21
      Width = 121
      Height = 21
      Enabled = False
      TabOrder = 0
      Text = 'Edit_id_jenis'
    end
    object Edit_jenis_barang: TEdit
      Left = 96
      Top = 48
      Width = 121
      Height = 21
      TabOrder = 1
      Text = 'Edit_jenis_barang'
    end
    object Edit_harga: TEdit
      Left = 96
      Top = 75
      Width = 121
      Height = 21
      TabOrder = 2
      Text = 'Edit_harga'
    end
    object Button_update: TButton
      Left = 10
      Top = 184
      Width = 75
      Height = 25
      Caption = 'UPDATE'
      TabOrder = 3
      OnClick = Button_updateClick
    end
    object Button_delete: TButton
      Left = 91
      Top = 184
      Width = 75
      Height = 25
      Caption = 'DELETE'
      TabOrder = 4
      OnClick = Button_deleteClick
    end
    object Button_simpan: TButton
      Left = 172
      Top = 184
      Width = 75
      Height = 25
      Caption = 'SIMPAN'
      TabOrder = 5
      OnClick = Button_simpanClick
    end
  end
  object Panel2: TPanel
    Left = 279
    Top = 8
    Width = 386
    Height = 313
    TabOrder = 1
    object DBGrid_harga_jenis_barang: TDBGrid
      Left = 16
      Top = 16
      Width = 345
      Height = 281
      DataSource = Data_Module.DataSource_jenis_barang
      TabOrder = 0
      TitleFont.Charset = DEFAULT_CHARSET
      TitleFont.Color = clWindowText
      TitleFont.Height = -11
      TitleFont.Name = 'Tahoma'
      TitleFont.Style = []
      OnCellClick = DBGrid_harga_jenis_barangCellClick
    end
  end
end
