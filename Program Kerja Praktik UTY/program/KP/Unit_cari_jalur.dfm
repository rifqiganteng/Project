object Form_cari_jalur: TForm_cari_jalur
  Left = 0
  Top = 0
  Caption = 'Form_cari_jalur'
  ClientHeight = 211
  ClientWidth = 471
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
  object DBGrid_cari_jalur: TDBGrid
    Left = 0
    Top = 8
    Width = 465
    Height = 169
    DataSource = Data_Module.DataSource_jalur
    TabOrder = 0
    TitleFont.Charset = DEFAULT_CHARSET
    TitleFont.Color = clWindowText
    TitleFont.Height = -11
    TitleFont.Name = 'Tahoma'
    TitleFont.Style = []
    OnCellClick = DBGrid_cari_jalurCellClick
    Columns = <
      item
        Expanded = False
        FieldName = 'id_jalur'
        Width = 90
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'kota_awal'
        Width = 120
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'kota_tujuan'
        Width = 150
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'harga'
        Width = 80
        Visible = True
      end>
  end
  object Button_pilih_cari_jalur: TButton
    Left = 186
    Top = 183
    Width = 75
    Height = 25
    Caption = 'PILIH'
    TabOrder = 1
    OnClick = Button_pilih_cari_jalurClick
  end
end
