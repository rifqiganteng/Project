object Form_jalur: TForm_jalur
  Left = 0
  Top = 0
  Caption = 'Form_jalur'
  ClientHeight = 281
  ClientWidth = 680
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
  object GroupBox1: TGroupBox
    Left = 8
    Top = 8
    Width = 361
    Height = 265
    Caption = 'GroupBox1'
    TabOrder = 0
    object TLabel
      Left = 16
      Top = 32
      Width = 41
      Height = 13
      Caption = 'ID_JAlur'
    end
    object Label1: TLabel
      Left = 16
      Top = 64
      Width = 48
      Height = 13
      Caption = 'Kota Awal'
    end
    object Label2: TLabel
      Left = 16
      Top = 96
      Width = 58
      Height = 13
      Caption = 'Kota Tujuan'
    end
    object Label3: TLabel
      Left = 16
      Top = 128
      Width = 29
      Height = 13
      Caption = 'Harga'
    end
    object Edit_id_jalur: TEdit
      Left = 80
      Top = 24
      Width = 145
      Height = 21
      Enabled = False
      TabOrder = 0
      Text = 'Edit_id_jalur'
    end
    object Edit_harga: TEdit
      Left = 80
      Top = 120
      Width = 145
      Height = 21
      TabOrder = 1
      Text = 'Edit_harga'
    end
    object Button_update_jalur: TButton
      Left = 16
      Top = 224
      Width = 75
      Height = 25
      Caption = 'UPDATE'
      TabOrder = 2
      OnClick = Button_update_jalurClick
    end
    object Button_delete_jalur: TButton
      Left = 105
      Top = 224
      Width = 75
      Height = 25
      Caption = 'DELETE'
      TabOrder = 3
      OnClick = Button_delete_jalurClick
    end
    object Button_simpan_jalur: TButton
      Left = 201
      Top = 224
      Width = 75
      Height = 25
      Caption = 'SIMPAN'
      TabOrder = 4
      OnClick = Button_simpan_jalurClick
    end
    object Edit_kota_awal: TEdit
      Left = 80
      Top = 56
      Width = 145
      Height = 21
      TabOrder = 5
      Text = 'Edit_kota_awal'
    end
    object Edit_kota_tujuan: TEdit
      Left = 80
      Top = 88
      Width = 145
      Height = 21
      TabOrder = 6
      Text = 'Edit_kota_tujuan'
    end
  end
  object GroupBox2: TGroupBox
    Left = 375
    Top = 8
    Width = 297
    Height = 265
    Caption = 'GroupBox2'
    TabOrder = 1
    object DBGrid1: TDBGrid
      Left = 8
      Top = 16
      Width = 286
      Height = 241
      DataSource = Data_Module.DataSource_jalur
      TabOrder = 0
      TitleFont.Charset = DEFAULT_CHARSET
      TitleFont.Color = clWindowText
      TitleFont.Height = -11
      TitleFont.Name = 'Tahoma'
      TitleFont.Style = []
      OnCellClick = DBGrid1CellClick
    end
  end
end
