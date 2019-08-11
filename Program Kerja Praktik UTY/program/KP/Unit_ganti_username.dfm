object Form_ganti_username: TForm_ganti_username
  Left = 0
  Top = 0
  Caption = 'Form_ganti_username'
  ClientHeight = 208
  ClientWidth = 394
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
    Width = 377
    Height = 193
    TabOrder = 0
    object Label1: TLabel
      Left = 152
      Top = 8
      Width = 118
      Height = 13
      Caption = 'GANTI USERNAME BARU'
    end
    object Label2: TLabel
      Left = 32
      Top = 43
      Width = 53
      Height = 13
      Caption = 'ID petugas'
    end
    object Label3: TLabel
      Left = 32
      Top = 70
      Width = 46
      Height = 13
      Caption = 'Password'
    end
    object Label4: TLabel
      Left = 32
      Top = 97
      Width = 48
      Height = 13
      Caption = 'Username'
    end
    object Label5: TLabel
      Left = 32
      Top = 124
      Width = 79
      Height = 13
      Caption = 'Username Baru  '
    end
    object Edit_ID_petugas: TEdit
      Left = 145
      Top = 40
      Width = 177
      Height = 21
      TabOrder = 0
      Text = 'Edit_ID_petugas'
    end
    object Edit_password_lama: TEdit
      Left = 145
      Top = 67
      Width = 177
      Height = 21
      TabOrder = 1
      Text = 'Edit_password_lama'
    end
    object Edit_username: TEdit
      Left = 145
      Top = 94
      Width = 177
      Height = 21
      TabOrder = 2
      Text = 'Edit_username'
    end
    object Edit_username_baru: TEdit
      Left = 145
      Top = 121
      Width = 177
      Height = 21
      TabOrder = 3
      Text = 'Edit_username_baru'
    end
    object Button_ganti_username: TButton
      Left = 247
      Top = 160
      Width = 75
      Height = 25
      Caption = 'UBAH'
      TabOrder = 4
      OnClick = Button_ganti_usernameClick
    end
    object Edit1: TEdit
      Left = 145
      Top = 282
      Width = 121
      Height = 21
      TabOrder = 5
      Text = 'Edit1'
    end
    object Edit2: TEdit
      Left = 18
      Top = 282
      Width = 121
      Height = 21
      TabOrder = 6
      Text = 'Edit2'
    end
  end
  object ADOQuery_ganti_username: TADOQuery
    Connection = Data_Module.ADOConnection1
    Parameters = <>
    Left = 344
    Top = 24
  end
  object ADOQuery1: TADOQuery
    Connection = Data_Module.ADOConnection1
    Parameters = <>
    Left = 344
    Top = 80
  end
end
