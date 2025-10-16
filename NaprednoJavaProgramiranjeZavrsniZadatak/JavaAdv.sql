CREATE TABLE Polaznik(
	PolaznikId INT NOT NULL IDENTITY PRIMARY KEY,
	Ime NVARCHAR(100) NOT NULL,
	Prezime NVARCHAR(100) NOT NULL
)

GO

CREATE TABLE ProgramObrazovanja(
	ProgramObrazovanjaId INT NOT NULL IDENTITY PRIMARY KEY,
	Naziv NVARCHAR(100) NOT NULL,
	CSVET INT NOT NULL
	)

GO

CREATE TABLE Upis(
	UpisId INT NOT NULL IDENTITY,
	IDProgramObrazovanja INT NOT NULL,
	IDPolaznik INT NOT NULL,

	FOREIGN KEY (IDProgramObrazovanja) REFERENCES ProgramObrazovanja(ProgramObrazovanjaId),
	FOREIGN KEY (IDPolaznik) REFERENCES Polaznik(PolaznikId)
)


GO

CREATE PROC dbo.dodajNovogPolaznika
	@name NVARCHAR(100),
	@surname NVARCHAR(100)
AS
	INSERT INTO dbo.Polaznik(Ime, Prezime)
	VALUES (@name,@surname)
	
GO


CREATE PROC dbo.dodajNoviProgramObrazovanja
	@name NVARCHAR(100),
	@points INT
AS
	INSERT INTO dbo.ProgramObrazovanja(Naziv, CSVET)
	VALUES (@name, @points)

GO

CREATE PROC dbo.UpisPolaznika
	@polaznik INT,
	@program INT
AS
	INSERT INTO dbo.Upis(IDPolaznik, IDProgramObrazovanja)
	VALUES (@polaznik, @program)

GO

CREATE PROC dbo.IspisiPolaznika
	@polaznik INT,
	@program INT
AS
	DELETE FROM dbo.Upis
	WHERE IDPolaznik = @polaznik AND IDProgramObrazovanja = @program

GO

CREATE PROC dbo.PrebaciPolaznika
	@polaznikout INT,
	@programOut INT,
	@programIn INT
AS
	BEGIN TRY
		BEGIN TRAN
			EXEC dbo.IspisiPolaznika
				@polaznik = @polaznikout,
				@program = @programOut
		
			EXEC dbo.UpisPolaznika
				@polaznik = @polaznikOut,
				@program = @programIn
		COMMIT
	END TRY
	BEGIN CATCH
		ROLLBACK
	END CATCH

GO		

CREATE PROC dbo.ispisiPolaznikeZaProgram
	@program INT
AS
	SELECT Ime, Prezime, Naziv, CSVET 
	FROM dbo.Upis
		JOIN dbo.Polaznik ON Polaznik.PolaznikId = Upis.IDPolaznik
		JOIN dbo.ProgramObrazovanja ON ProgramObrazovanja.ProgramObrazovanjaId = Upis.IDProgramObrazovanja
	WHERE IDProgramObrazovanja = @program

GO
	