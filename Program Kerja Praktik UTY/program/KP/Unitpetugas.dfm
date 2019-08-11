object Form_petugas: TForm_petugas
  Left = 0
  Top = 0
  Caption = 'Form_petugas'
  ClientHeight = 478
  ClientWidth = 895
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
  object TLabel
    Left = 24
    Top = 69
    Width = 3
    Height = 13
  end
  object GroupBox1: TGroupBox
    Left = 8
    Top = 8
    Width = 449
    Height = 425
    Caption = 'GroupBox1'
    TabOrder = 0
    object Label1: TLabel
      Left = 16
      Top = 40
      Width = 56
      Height = 13
      Caption = 'ID_Petugas'
    end
    object Label2: TLabel
      Left = 16
      Top = 72
      Width = 27
      Height = 13
      Caption = 'Nama'
    end
    object Label3: TLabel
      Left = 16
      Top = 104
      Width = 33
      Height = 13
      Caption = 'Alamat'
    end
    object Label4: TLabel
      Left = 16
      Top = 136
      Width = 63
      Height = 13
      Caption = 'Jenis Kelamin'
    end
    object Label5: TLabel
      Left = 16
      Top = 168
      Width = 64
      Height = 13
      Caption = 'Tanggal Lahir'
    end
    object Label6: TLabel
      Left = 16
      Top = 200
      Width = 47
      Height = 13
      Caption = 'Nomor HP'
    end
    object Label7: TLabel
      Left = 16
      Top = 232
      Width = 48
      Height = 13
      Caption = 'Username'
    end
    object Label8: TLabel
      Left = 16
      Top = 264
      Width = 41
      Height = 13
      Caption = 'Pasword'
    end
    object TLabel
      Left = 16
      Top = 296
      Width = 49
      Height = 13
      Caption = 'Hak Akses'
    end
    object Edit_ID_petugas: TEdit
      Left = 120
      Top = 32
      Width = 137
      Height = 21
      TabOrder = 0
      Text = 'Edit_ID_petugas'
    end
    object Edit_nama_petugas: TEdit
      Left = 120
      Top = 64
      Width = 137
      Height = 21
      TabOrder = 1
      Text = 'Edit_nama_petugas'
    end
    object Edit_Alamat_petugas: TEdit
      Left = 120
      Top = 96
      Width = 137
      Height = 21
      TabOrder = 2
      Text = 'Edit_Alamat_petugas'
    end
    object Edit_nomor_hp: TEdit
      Left = 120
      Top = 192
      Width = 137
      Height = 21
      TabOrder = 3
      Text = 'Edit_nomor_hp'
    end
    object Edit_username: TEdit
      Left = 120
      Top = 224
      Width = 137
      Height = 21
      TabOrder = 4
      Text = 'Edit_username'
    end
    object Edit_pasword: TEdit
      Left = 120
      Top = 256
      Width = 137
      Height = 21
      TabOrder = 5
      Text = 'Edit_pasword'
    end
    object Button_update: TButton
      Left = 104
      Top = 336
      Width = 75
      Height = 25
      Caption = 'UPDATE'
      TabOrder = 6
      OnClick = Button_updateClick
    end
    object Button_delete: TButton
      Left = 192
      Top = 336
      Width = 75
      Height = 25
      Caption = 'DELETE'
      TabOrder = 7
      OnClick = Button_deleteClick
    end
    object Button_simpan: TButton
      Left = 280
      Top = 336
      Width = 75
      Height = 25
      Caption = 'SIMPAN'
      TabOrder = 8
      OnClick = Button_simpanClick
    end
    object ComboBox_hakakses: TComboBox
      Left = 120
      Top = 288
      Width = 137
      Height = 21
      TabOrder = 9
      Text = 'ComboBox'
      OnKeyPress = ComboBox_hakaksesKeyPress
      Items.Strings = (
        'ADMIN'
        'PETUGAS')
    end
    object ComboBox_jenis_kelamin: TComboBox
      Left = 120
      Top = 128
      Width = 137
      Height = 21
      TabOrder = 10
      Text = 'ComboBox_jenis_kelamin'
      OnKeyPress = ComboBox_jenis_kelaminKeyPress
      Items.Strings = (
        'LAKI-LAKI'
        'PEREMPUAN')
    end
    object DateTimePicker_tanggal: TDateTimePicker
      Left = 120
      Top = 160
      Width = 137
      Height = 21
      Date = 42388.355395393520000000
      Time = 42388.355395393520000000
      TabOrder = 11
    end
  end
  object GroupBox2: TGroupBox
    Left = 454
    Top = 8
    Width = 441
    Height = 425
    Caption = 'GroupBox2'
    TabOrder = 1
    object DBGrid1: TDBGrid
      Left = 8
      Top = 32
      Width = 425
      Height = 329
      DataSource = Data_Module.DataSource_petugas
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
