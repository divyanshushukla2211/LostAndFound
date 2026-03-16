import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/items") // All URLs in this class will start with /items
public class ItemController {

    @Autowired
    private ItemService itemService;

    // Report a new found item
    // POST request to http://localhost:8080/items
    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    // See all items
    // GET request to http://localhost:8080/items
    @GetMapping
    public List<Item> getItems() {
        return itemService.getAllItems();
    }

    // See a specific item by ID
    // GET request to http://localhost:8080/items/1
    @GetMapping("/{id}")
    public Item getItem(@PathVariable Long id) {
        return itemService.findItemById(id);
    }

    // Update an item (e.g., mark as "Claimed")
    // PUT request to http://localhost:8080/items/1
    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
        item.setItemId(id); // Ensure the ID from the URL is set on the object
        return itemService.updateItem(item);
    }

    // Delete an item permanently
    // DELETE request to http://localhost:8080/items/1
    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return "Item Deleted Successfully";
    }
}
