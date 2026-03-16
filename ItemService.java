import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepo;

    // CREATE: Add a newly found item
    public Item createItem(Item item) {
        return itemRepo.save(item);
    }

    // READ: Get all items
    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }

    // READ: Get a specific item by its ID
    public Item findItemById(Long id) {
        return itemRepo.findById(id).orElse(null);
    }

    // UPDATE: Update an item (e.g., changing status to "Claimed")
    public Item updateItem(Item item) {
        // save() works for both creating and updating. 
        // If the ID already exists, it updates the record.
        return itemRepo.save(item); 
    }

    // DELETE: Remove an item from the database
    public void deleteItem(Long id) {
        itemRepo.deleteById(id);
    }
}
