import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.danpexam01.models.Medico


@Dao
interface MedicoDao {
    @Insert
    suspend fun insertMedico(médico: Medico)

    @Query("SELECT * FROM medicos")
    fun getAllMedicos(): LiveData<List<Medico>>
}