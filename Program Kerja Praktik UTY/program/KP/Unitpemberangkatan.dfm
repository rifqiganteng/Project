object Form_pemberangkatan: TForm_pemberangkatan
  Left = 0
  Top = 0
  Caption = 'Form_pemberangkatan'
  ClientHeight = 495
  ClientWidth = 386
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
    Left = 16
    Top = 16
    Width = 345
    Height = 161
    Caption = 'GroupBox1'
    TabOrder = 0
    object Label1: TLabel
      Left = 8
      Top = 24
      Width = 95
      Height = 13
      Caption = 'ID Pemberangkatan'
    end
    object Label3: TLabel
      Left = 8
      Top = 64
      Width = 103
      Height = 13
      Caption = 'Jam Pemberangkatan'
    end
    object Edit_id_pemberangkatan: TEdit
      Left = 128
      Top = 24
      Width = 185
      Height = 21
      Enabled = False
      TabOrder = 0
      Text = 'Edit_id_pemberangkatan'
    end
    object Button_update_pemberangkatan: TButton
      Left = 8
      Top = 112
      Width = 75
      Height = 25
      Caption = 'UPDATE'
      Enabled = False
      TabOrder = 1
      OnClick = Button_update_pemberangkatanClick
    end
    object Button_delete_pemberangkatan: TButton
      Left = 128
      Top = 112
      Width = 75
      Height = 25
      Caption = 'DELETE'
      Enabled = False
      TabOrder = 2
      OnClick = Button_delete_pemberangkatanClick
    end
    object Button_simpan_pemberangkatan: TButton
      Left = 232
      Top = 112
      Width = 75
      Height = 25
      Caption = 'SIMPAN'
      TabOrder = 3
      OnClick = Button_simpan_pemberangkatanClick
    end
    object Edit_jam_pemberangkatan: TEdit
      Left = 128
      Top = 56
      Width = 185
      Height = 21
      TabOrder = 4
      Text = 'Edit_jam_pemberangkatan'
    end
  end
  object GroupBox2: TGroupBox
    Left = 16
    Top = 183
    Width = 345
    Height = 250
    Caption = 'GroupBox2'
    TabOrder = 1
    object DBGrid1: TDBGrid
      Left = 3
      Top = 32
      Width = 313
      Height = 193
      DataSource = Data_Module.DataSource_pemberangkatan
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
