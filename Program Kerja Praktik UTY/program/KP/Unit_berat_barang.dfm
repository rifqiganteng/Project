object Form_harga: TForm_harga
  Left = 0
  Top = 0
  Caption = 'Form'
  ClientHeight = 351
  ClientWidth = 744
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
  object Panel: TPanel
    Left = 8
    Top = 8
    Width = 337
    Height = 321
    TabOrder = 0
    object Label1: TLabel
      Left = 16
      Top = 24
      Width = 40
      Height = 13
      Caption = 'id_berat'
    end
    object Label2: TLabel
      Left = 16
      Top = 56
      Width = 47
      Height = 13
      Caption = 'berat / kg'
    end
    object Label3: TLabel
      Left = 16
      Top = 83
      Width = 28
      Height = 13
      Caption = 'harga'
    end
    object Edit_id_berat: TEdit
      Left = 88
      Top = 24
      Width = 121
      Height = 21
      Enabled = False
      TabOrder = 0
      Text = 'Edit_id_berat'
    end
    object Edit_berat_kg: TEdit
      Left = 88
      Top = 51
      Width = 121
      Height = 21
      TabOrder = 1
    end
    object Edit_harga_berat: TEdit
      Left = 88
      Top = 83
      Width = 121
      Height = 21
      TabOrder = 2
      Text = 'Edit1'
    end
    object Button_update: TButton
      Left = 16
      Top = 144
      Width = 75
      Height = 25
      Caption = 'UPDATE'
      TabOrder = 3
      OnClick = Button_updateClick
    end
    object Button_delete: TButton
      Left = 97
      Top = 144
      Width = 75
      Height = 25
      Caption = 'DELETE'
      TabOrder = 4
      OnClick = Button_deleteClick
    end
    object Button_simpan: TButton
      Left = 178
      Top = 144
      Width = 75
      Height = 25
      Caption = 'SIMPAN'
      TabOrder = 5
      OnClick = Button_simpanClick
    end
  end
  object Panel1: TPanel
    Left = 351
    Top = 8
    Width = 370
    Height = 321
    TabOrder = 1
    object DBGrid_berat: TDBGrid
      Left = 16
      Top = 8
      Width = 345
      Height = 305
      DataSource = Data_Module.DataSource_berat_barang
      TabOrder = 0
      TitleFont.Charset = DEFAULT_CHARSET
      TitleFont.Color = clWindowText
      TitleFont.Height = -11
      TitleFont.Name = 'Tahoma'
      TitleFont.Style = []
      OnCellClick = DBGrid_beratCellClick
    end
  end
end
